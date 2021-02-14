package com.desafio_android_gustavo_rocha.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.desafio_android_gustavo_rocha.R
import com.desafio_android_gustavo_rocha.databinding.FragmentComicBinding
import com.desafio_android_gustavo_rocha.models.Comic
import com.desafio_android_gustavo_rocha.ui.viewmodel.ComicViewModel
import com.squareup.picasso.Picasso
import org.koin.android.viewmodel.ext.android.viewModel

class ComicFragment : Fragment(R.layout.fragment_comic) {

    private val comicViewModel by viewModel<ComicViewModel>()
    private val argument by navArgs<ComicFragmentArgs>()
    private val idPersonagem by lazy { argument.comicId }
    private lateinit var binding: FragmentComicBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentComicBinding.bind(view)
        getComicByCharacterId(idPersonagem)
    }

    private fun getComicByCharacterId(personagemId: Int) {
        comicViewModel.buscarPersonagemPorId(personagemId)
            .observe(
                viewLifecycleOwner,
                Observer { comics -> comics?.let { instantiateFields(it) } })
    }

    private fun instantiateFields(comics: List<Comic>) {

        //mudar para price
        val comicMaisCara = comics.sortedBy { it.id }
        val comic = comicMaisCara[0]

        binding.comicTvTitulo.text = comic.title

        if (comic.description == null || comic.description.isBlank()) {
            binding.comicTvDescricao.text = "without description"
        }

        binding.comicTvDescricao.text = comic.description

        Picasso.get().load(comic.thumbnail?.path + "." + comic.thumbnail?.extension)
            .into(binding.comicImgPersonagem)

        val price = comic.prices?.get(0)?.price

        binding.comicTvPreco.text = "$ " + price.toString()
    }
}