package com.example.finalproject125;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private LinearLayout llContainer;
    private EditText etSearch;
    private ListView lvProducts;

    // private ArrayList<Product> mProductArrayList = new ArrayList<Product>();
    private MyAdapter adapter1;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initialize();



        // Add Text Change Listener to EditText
        etSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Call back the Adapter with current character to Filter
                adapter1.getFilter().filter(s.toString());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void initialize() {
        etSearch = (EditText) findViewById(R.id.etSearch);
        lvProducts = (ListView)findViewById(R.id.lvOS);
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();

        mProductArrayList.add(new Product("a", 100));
        mProductArrayList.add(new Product("b", 200));
        mProductArrayList.add(new Product("c", 300));
        mProductArrayList.add(new Product("d", 400));
        mProductArrayList.add(new Product("e", 500));
        mProductArrayList.add(new Product("f", 600));
        mProductArrayList.add(new Product("g", 700));
        mProductArrayList.add(new Product("h", 800));
        mProductArrayList.add(new Product("i", 900));
        mProductArrayList.add(new Product("j", 1000));
        mProductArrayList.add(new Product("k", 1100));
        mProductArrayList.add(new Product("l", 1200));
        mProductArrayList.add(new Product("m", 1000));
        mProductArrayList.add(new Product("n", 1300));
        mProductArrayList.add(new Product("o", 1400));
        mProductArrayList.add(new Product("p", 1500));


        adapter1 = new MyAdapter(MainActivity.this, mProductArrayList);
        lvProducts.setAdapter(adapter1);
    }


    // Adapter Class
    public class MyAdapter extends BaseAdapter implements Filterable {

        private ArrayList<Product> mOriginalValues; // Original Values
        private ArrayList<Product> mDisplayedValues;    // Values to be displayed
        LayoutInflater inflater;

        public MyAdapter(Context context, ArrayList<Product> mProductArrayList) {
            this.mOriginalValues = mProductArrayList;
            this.mDisplayedValues = mProductArrayList;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return mDisplayedValues.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        private class ViewHolder {
            LinearLayout llContainer;
            TextView tvName,tvPrice;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;

            if (convertView == null) {

                holder = new ViewHolder();
                convertView = inflater.inflate(R.layout.row, null);
                holder.llContainer = (LinearLayout)convertView.findViewById(R.id.llContainer);
                holder.tvName = (TextView) convertView.findViewById(R.id.tvName);
                holder.tvPrice = (TextView) convertView.findViewById(R.id.tvPrice);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.tvName.setText(mDisplayedValues.get(position).name);
            holder.tvPrice.setText(mDisplayedValues.get(position).price+"");

            holder.llContainer.setOnClickListener(new OnClickListener() {

                public void onClick(View v) {

                    Toast.makeText(MainActivity.this, mDisplayedValues.get(position).name, Toast.LENGTH_SHORT).show();
                }
            });

            return convertView;
        }

        @Override
        public Filter getFilter() {
            Filter filter = new Filter() {

                @SuppressWarnings("unchecked")
                @Override
                protected void publishResults(CharSequence constraint,FilterResults results) {

                    mDisplayedValues = (ArrayList<Product>) results.values; // has the filtered values
                    notifyDataSetChanged();  // notifies the data with new filtered values
                }

                @Override
                protected FilterResults performFiltering(CharSequence constraint) {
                    FilterResults results = new FilterResults();        // Holds the results of a filtering operation in values
                    ArrayList<Product> FilteredArrList = new ArrayList<Product>();

                    if (mOriginalValues == null) {
                        mOriginalValues = new ArrayList<Product>(mDisplayedValues); // saves the original data in mOriginalValues
                    }

                    /********
                     *
                     *  If constraint(CharSequence that is received) is null returns the mOriginalValues(Original) values
                     *  else does the Filtering and returns FilteredArrList(Filtered)
                     *
                     ********/
                    if (constraint == null || constraint.length() == 0) {

                        // set the Original result to return
                        results.count = mOriginalValues.size();
                        results.values = mOriginalValues;
                    } else {
                        constraint = constraint.toString().toLowerCase();
                        for (int i = 0; i < mOriginalValues.size(); i++) {
                            String data = mOriginalValues.get(i).name;
                            if (data.toLowerCase().startsWith(constraint.toString())) {
                                FilteredArrList.add(new Product(mOriginalValues.get(i).name,mOriginalValues.get(i).price));
                            }
                        }
                        // set the Filtered result to return
                        results.count = FilteredArrList.size();
                        results.values = FilteredArrList;
                    }
                    return results;
                }
            };
            return filter;
        }
    }

    // this is the code that
    private Button shuffle;
    private TextView saySome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saySome = findViewById(R.id.saySome);
        saySome.setVisibility(View.GONE);

        shuffle = findViewById(R.id.shuffleAnything);
        shuffle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generateEpisode();
            }
        });
    }

    public void generateEpisode() {
        saySome.setVisibility(View.VISIBLE);
    }
}
