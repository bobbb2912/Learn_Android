package bobbb2912.com.appdulich1;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.menu.MenuView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import bobbb2912.com.appdulich1.ui.main.SectionsPagerAdapter;
import bobbb2912.com.appdulich1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity  {

    private ActivityMainBinding binding;
    BottomNavigationItemView Profile;
    private ActionBar toolbar;
//    NavigationView bottomNavigationView;

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);
//        FloatingActionButton fab = binding.fab;

//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//    }

//
    }
//    @Override
//    public boolean onCreateOptionsMenu (Menu menu){
//            MenuInflater inflater = getMenuInflater();
//            inflater.inflate(R.menu.search, menu);
//            return true;
//    }
//
//        @Override
//    public boolean onOptionsItemSelected (@NonNull MenuItem item){
//        switch (item.getItemId()) {
//            case R.id.Profile:
//                Toast.makeText(this, "click profile", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
//                startActivity(intent);
//                break;
//        }
//            return super.onOptionsItemSelected(item);
//    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.Profile:
                    toolbar.setTitle("Profile");
                    fragment = new ProfileFragment();
                    loadFragment(fragment);
                    return true;
//                case R.id.navigation_gifts:
//                    toolbar.setTitle("My Gifts");
//                    return true;
//                case R.id.navigation_cart:
//                    toolbar.setTitle("Cart");
//                    return true;
//                case R.id.navigation_profile:
//                    toolbar.setTitle("Profile");
//                    return true;
            }
                return false;
            }
        };
    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }



    public void init() {
        Profile = findViewById(R.id.Profile);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

//        bottomNavigationView.setOnNavigationItemSelectedListener();
//        bottomNavigationView.setOnNavigationItemSelectedListener(MainActivity.this);

    }

    ProfileFragment profileFragment = new ProfileFragment();

//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.Profile:
//                getSupportFragmentManager().beginTransaction().replace(androidx.fragment.R.id.action_container, profileFragment).commit();
//                return true;
//
////            case R.id.home:
////                getSupportFragmentManager().beginTransaction().replace(R.id.container, secondFragment).commit();
////                return true;
////
////            case R.id.settings:
////                getSupportFragmentManager().beginTransaction().replace(R.id.container, thirdFragment).commit();
////                return true;
//        }
//        return false;
//    }


}