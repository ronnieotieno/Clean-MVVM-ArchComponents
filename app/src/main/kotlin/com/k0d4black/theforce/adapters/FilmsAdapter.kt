/**
 *
 * Copyright 2020 David Odari
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *          http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 **/
package com.k0d4black.theforce.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.k0d4black.theforce.databinding.ItemFilmBinding
import com.k0d4black.theforce.models.FilmPresentation

internal class FilmsAdapter : ListAdapter<FilmPresentation, FilmsAdapter.FilmViewHolder>(DiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        return FilmViewHolder(ItemFilmBinding.inflate(inflater))
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int): Unit =
        getItem(position).let { holder.bind(it) }

    inner class FilmViewHolder(
        private val binding: ItemFilmBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(filmPresentation: FilmPresentation) {
            binding.film = filmPresentation
            binding.executePendingBindings()
        }
    }

    companion object {
        val DiffUtil =
            object : DiffUtil.ItemCallback<FilmPresentation>() {
                override fun areItemsTheSame(
                    oldItem: FilmPresentation,
                    newItem: FilmPresentation
                ): Boolean = oldItem == newItem


                override fun areContentsTheSame(
                    oldItem: FilmPresentation,
                    newItem: FilmPresentation
                ): Boolean = oldItem.title == newItem.title
            }
    }
}