package com.example.catchat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

data class Cat(val name: String, val status: String, val about: String)

class CatsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cats, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list: LinearLayout = view.findViewById(R.id.cat_list)
        val cats = buildCats()

        for (cat in cats) {
            val card = createCatCard(cat, list)
            list.addView(card)
        }
    }

    private fun buildCats(): ArrayList<Cat> {
        val cats = ArrayList<Cat>()
        cats.add(
            Cat(
                "Барсик",
                "В сети",
                "Рыжий кот трёх лет. Любит спать на клавиатуре и обсуждать корм."
            )
        )
        cats.add(
            Cat(
                "Мурка",
                "Была недавно",
                "Трёхцветная кошка, живёт на подоконнике. Пишет только по утрам."
            )
        )
        cats.add(
            Cat(
                "Феликс",
                "Не беспокоить",
                "Чёрный кот, ночная смена. Отвечает после полуночи."
            )
        )
        cats.add(
            Cat(
                "Симба",
                "В сети",
                "Рыжий котёнок, очень болтливый. Присылает много голосовых."
            )
        )
        return cats
    }

    private fun createCatCard(cat: Cat, parent: ViewGroup): View {
        val inflater = LayoutInflater.from(requireContext())
        val card = inflater.inflate(R.layout.item_cat, parent, false)

        val nameView: TextView = card.findViewById(R.id.cat_name)
        val statusView: TextView = card.findViewById(R.id.cat_status)
        nameView.text = cat.name
        statusView.text = cat.status

        card.setOnClickListener {
            val bundle = Bundle()
            bundle.putString(CatDetailsFragment.ARG_NAME, cat.name)
            bundle.putString(CatDetailsFragment.ARG_STATUS, cat.status)
            bundle.putString(CatDetailsFragment.ARG_ABOUT, cat.about)

            val controller = findNavController()
            controller.navigate(R.id.action_catsFragment_to_catDetailsFragment, bundle)
        }

        return card
    }
}
