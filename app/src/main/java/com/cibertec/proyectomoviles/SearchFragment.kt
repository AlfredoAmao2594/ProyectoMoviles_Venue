ppackage com.cibertec.proyectomoviles
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import androidx.fragment.app.Fragment

class SearchFragment : Fragment() {

    private lateinit var returnHome1: ImageView
    private lateinit var searchEditText: EditText
    private lateinit var resultsListView: ListView
    private lateinit var allItems: List<String> // Todos los elementos
    private val filteredItems = mutableListOf<String>() // Elementos filtrados
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializar vistas
        returnHome1 = view.findViewById(R.id.imgReturnMenu2)
        searchEditText = view.findViewById(R.id.edtBuscar)
        resultsListView = view.findViewById(R.id.resultsListView)

        // Inicializar lista de elementos (allItems)
        allItems = listOf("Item 1", "Item 2", "Item 3") // Agrega tus elementos aquí

        // Inicializar adaptador y lista de resultados
        adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, filteredItems)
        resultsListView.adapter = adapter

        // Agregar TextWatcher para filtrar los resultados en tiempo real
        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filterResults(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        returnHome1.setOnClickListener {
            val intent = Intent(requireContext(), MenuActivity::class.java)
            startActivity(intent)
        }
    }

    // Método para filtrar los resultados
    private fun filterResults(query: String) {
        filteredItems.clear()
        for (item in allItems) {
            if (item.contains(query, ignoreCase = true)) {
                filteredItems.add(item)
            }
        }
        adapter.notifyDataSetChanged()
    }
}
