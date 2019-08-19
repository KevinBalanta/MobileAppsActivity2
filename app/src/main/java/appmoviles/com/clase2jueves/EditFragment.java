package appmoviles.com.clase2jueves;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class EditFragment extends Fragment {

    private EditText descriptionEt;
    private Button descriptionBtn;

    public EditFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_edit, container, false);
       descriptionEt = view.findViewById(R.id.edit_description_et);
       descriptionBtn = view.findViewById(R.id.edit_description_btn);

       descriptionBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String description = descriptionEt.getText().toString();
               if(listener!=null) listener.onDescriptionEdit(description);
               ((NavActivity ) getActivity()).showProfileFragments();
           }
       });

       return view;
    }


    //patrón observer

    public interface OnDescriptionListener{
        void onDescriptionEdit(String description);
    }


    private OnDescriptionListener listener;

    public void setListener(OnDescriptionListener listener){
        this.listener = listener;
    }
}
