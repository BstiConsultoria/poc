package br.com.casadocodigo.boaviagem;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Luis.SILVA.ext on 20/09/2016.
 */

public class GastoListActivity extends ListActivity
        implements AdapterView.OnItemClickListener {

    private List<Map<String, Object>> gastos;
    private String dataAnterior = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*
        // Aqui temos uma lista sem a necessidade de criação do layout
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listarGastos()));
        ListView listView = getListView();
        listView.setOnItemClickListener(this);
        */
        super.onCreate(savedInstanceState);
        String[] de = { "data", "descricao", "valor", "categoria" };
        int[] para = { R.id.data, R.id.descricao,
                R.id.valor, R.id.categoria };
        SimpleAdapter adapter = new SimpleAdapter(this,
                listarGastos(), R.layout.lista_gasto, de, para);
        adapter.setViewBinder(new GastoViewBinder());
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }
    /*
    @Override
    public void onItemClick(AdapterView<?> parent, View view,
                            int position, long id) {
        TextView textView = (TextView) view;
        Toast.makeText(this,"Gasto selecionado: "
                + textView.getText(), Toast.LENGTH_SHORT).show();
    }
    */

    @Override
    public void onItemClick(AdapterView<?> parent, View view,
                            int position, long id) {
        Map<String, Object> map = gastos.get(position);
        String descricao = (String) map.get("descricao");
        String mensagem = "Gasto selecionado: " + descricao;
        Toast.makeText(this, mensagem,Toast.LENGTH_SHORT).show();
    }
    /*
    private List<String> listarGastos() {
        return Arrays.asList("Sanduíche R$ 19,90","Táxi Aeroporto - Hotel R$ 34,00",
                "Revista R$ 12,00");
    }
    */

    private List<Map<String, Object>> listarGastos() {
        gastos = new ArrayList<Map<String, Object>>();

        Map<String, Object> item0 =
                new HashMap<String, Object>();
        item0.put("data", "03/02/2012");
        item0.put("descricao", "Diária Hotel");
        item0.put("valor", "R$ 260,00");
        item0.put("categoria", R.color.categoria_hospedagem);
        gastos.add(item0);

        Map<String, Object> item1 =
                new HashMap<String, Object>();
        item1.put("data", "04/02/2012");
        item1.put("descricao", "Diária Hotel");
        item1.put("valor", "R$ 260,00");
        item1.put("categoria", R.color.categoria_hospedagem);
        gastos.add(item1);

        Map<String, Object> item2 =
                new HashMap<String, Object>();

        item2.put("data", "04/02/2012");
        item2.put("descricao", "MC Donald");
        item2.put("valor", "R$ 50,00");
        item2.put("categoria", R.color.categoria_alimentacao);
        gastos.add(item2);

        Map<String, Object> item3 =
                new HashMap<String, Object>();

        item3.put("data", "04/02/2012");
        item3.put("descricao", "Fretado");
        item3.put("valor", "R$ 10,00");
        item3.put("categoria", R.color.categoria_transporte);
        gastos.add(item3);

        Map<String, Object> item4 =
                new HashMap<String, Object>();

        item4.put("data", "04/02/2012");
        item4.put("descricao", "Farmacia");
        item4.put("valor", "R$ 15,00");
        item4.put("categoria", R.color.categoria_outros);
        gastos.add(item4);

        // pode adicionar mais informações de viagens
        return gastos;
    }

    private class GastoViewBinder implements SimpleAdapter.ViewBinder {
        @Override
        public boolean setViewValue(View view, Object data,
                                    String textRepresentation) {
            if(view.getId() == R.id.data){
                if(!dataAnterior.equals(data)){
                    TextView textView = (TextView) view;
                    textView.setText(textRepresentation);
                    dataAnterior = textRepresentation;
                    view.setVisibility(View.VISIBLE);
                } else {
                    view.setVisibility(View.GONE);
                }
                return true;
            }
            if(view.getId() == R.id.categoria){
                Integer id = (Integer) data;
                view.setBackgroundColor(
                        getResources().getColor(id));
                return true;
            }
            return false;
        }
    }
}
