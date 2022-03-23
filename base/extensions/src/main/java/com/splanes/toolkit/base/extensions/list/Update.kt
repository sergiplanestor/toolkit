package com.splanes.toolkit.base.extensions.list

import com.splanes.toolkit.base.extensions.list.conflict.ListUtil
import com.splanes.toolkit.base.extensions.list.conflict.ListUtil.OnConflict.Companion.errorMessage
import com.splanes.toolkit.base.logger.utils.throwMessage


fun <E> List<E>.mutate(apply: MutableList<E>.() -> Unit): MutableList<E> =
    (if (this is MutableList) this else toMutableList()).apply(apply)

fun <E> List<E>.removeAll(matcher: (E) -> Boolean): MutableList<E> = mutate {
    filter(matcher).forEach { item -> remove(item) }
}

fun <E> List<E>.replace(old: E, new: E): MutableList<E> = mutate {
    val index = indexOf(old)
    removeAt(index)
    add(index, new)
}

fun <E> List<E>.replace(
    matcher: (E) -> Boolean,
    transformation: (E) -> E
): MutableList<E> = mutate {
    find(matcher)?.run { replace(old = this, new = transformation(this)) }
}

fun <E> List<E>.replaceAll(
    matcher: (E) -> Boolean,
    transformation: (E) -> E
): MutableList<E> = mutate {
    filter(matcher).forEach { item -> replace(old = item, new = transformation(item)) }
}

fun <E> List<E>.addAll(index: Int? = null, items: Collection<E>): MutableList<E> = mutate {
    addAll(safeIndex(index), items)
}

fun <E> List<E>.add(index: Int? = null, item: E): MutableList<E> =
    addAll(index, listOf(item))

fun <E> List<E>.addUnique(
    item: E,
    index: Int? = null,
    onConflict: ListUtil.OnConflict = ListUtil.OnConflict.Abort,
    checker: (E) -> Boolean = { it == item }
): MutableList<E> = mutate {
    when (count(checker)) {
        0 -> addAll(index, listOf(item))
        else -> {
            when (onConflict) {
                ListUtil.OnConflict.Abort -> {
                    // Do nothing
                }
                ListUtil.OnConflict.Replace -> {
                    replaceAll(matcher = checker, transformation = { item })
                }
                ListUtil.OnConflict.Error -> {
                    throwMessage { errorMessage(item.toString()) }
                }
            }
        }
    }
}
