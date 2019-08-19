package appmoviles.com.clase2jueves;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements EditFragment.OnDescriptionListener {


    private TextView profileDescription;
    private String description = "Ninguno";



    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        profileDescription = view.findViewById(R.id.profile_descripcion);
        profileDescription.setText(description);
        return view;
    }

    @Override
    public void onDescriptionEdit(String description) {
        this.description = description;
    }
}
