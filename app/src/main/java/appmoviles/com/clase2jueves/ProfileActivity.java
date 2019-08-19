package appmoviles.com.clase2jueves;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener{
    private LinearLayout fragmentsContainer;
    private Button profileBtn;
    private Button editBtn;
    private Button optionsBtn;

    private ProfileFragment profileFragment;
    private EditFragment editFragment;
    private OptionsFragment optionsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileFragment = new ProfileFragment();
        editFragment = new EditFragment();
        optionsFragment = new OptionsFragment();


        editFragment.setListener(profileFragment);


        fragmentsContainer = findViewById(R.id.fragments_container);
        profileBtn = findViewById(R.id.profile_btn);
        editBtn = findViewById(R.id.edit_btn);
        optionsBtn = findViewById(R.id.options_btn);

        profileBtn.setOnClickListener(this);
        editBtn.setOnClickListener(this);
        optionsBtn.setOnClickListener(this);
        showProfileFragments();
    }




    @Override
    public void onClick(View view) {

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();

        if(view.equals(profileBtn)){

            ft.replace(R.id.fragments_container, profileFragment);



        }else if(view.equals(editBtn)){
            ft.replace(R.id.fragments_container, editFragment);
        }else if(view.equals(optionsBtn)){
            ft.replace(R.id.fragments_container, optionsFragment);
        }

        ft.commit();
    }


    public void showProfileFragments(){
        onClick(profileBtn);
    }
}
