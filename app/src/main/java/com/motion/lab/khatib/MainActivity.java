package com.motion.lab.khatib;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.motion.lab.khatib.model.Jadwal;
import com.motion.lab.khatib.model.Masjid;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements JadwalFragment.OnListFragmentInteractionListener{

    /* DUMMY DATA */
    private List<Jadwal> arrayListJadwal;
    public List<Jadwal> arrayListJadwalLewat;
    public List<Jadwal> arrayListJadwalAkanDatang;

    private void setupDummyData(){
        Masjid almanar4 = new Masjid("AL-MANAR 4", "Jl. Toska 1", "Taufiq", "taufiq@khatib.com",
                "+6233332221");
        Masjid baiturrahman = new Masjid("BAITURRAHMAN", "Jl. Toska 2", "Syahrir", "Syahrir@khatib.com",
                "+6233332211");
        Masjid nurulHuda = new Masjid("NURUL HUDA", "Jl. Bojongsoang, Komp blabla", "Huda",
                "Huda@khatib.com", "+6233332221");
        Masjid almuslim2 = new Masjid("AL-MUSLIM 2", "Jl. Toska 1", "Taufiq", "taufiq@khatib.com",
                "+6233332221");
        Masjid arrazaq = new Masjid("AR-RAZAQ", "Jl. Toska 1", "Taufiq", "taufiq@khatib.com",
                "+6233332221");
        Masjid alfurqon = new Masjid("AL-FURQON", "Jl. Toska 1", "Taufiq", "taufiq@khatib.com",
                "+6233332221");
        Masjid almanar1 = new Masjid("AL-MANAR 1", "Jl. Toska 1", "Taufiq", "taufiq@khatib.com",
                "+6233332221");
        Masjid almanar2 = new Masjid("AL-MANAR 2", "Jl. Toska 1", "Taufiq", "taufiq@khatib.com",
                "+6233332221");
        Masjid almanar3 = new Masjid("AL-MANAR 3", "Jl. Toska 1", "Taufiq", "taufiq@khatib.com",
                "+6233332221");
        Masjid annurr = new Masjid("AN-NUUR", "Jl. Toska 1", "Taufiq", "taufiq@khatib.com",
                "+6233332221");
        Masjid alikhlas = new Masjid("AL-IKHLAS", "Jl. Toska 1", "Taufiq", "taufiq@khatib.com",
                "+6233332221");

        Calendar calendar = Calendar.getInstance();
        arrayListJadwal = new ArrayList<>();
        calendar.set(2016, Calendar.JULY, 15);
        arrayListJadwal.add(new Jadwal(almanar4, calendar.getTime()));
        calendar.set(2016, Calendar.JULY, 22);
        arrayListJadwal.add(new Jadwal(baiturrahman, calendar.getTime()));
        calendar.set(2016, Calendar.JULY, 29);
        arrayListJadwal.add(new Jadwal(nurulHuda, calendar.getTime()));
        calendar.set(2016, Calendar.AUGUST, 5);
        arrayListJadwal.add(new Jadwal(almuslim2, calendar.getTime()));
        calendar.set(2016, Calendar.AUGUST, 12);
        arrayListJadwal.add(new Jadwal(arrazaq, calendar.getTime()));
        calendar.set(2016, Calendar.AUGUST, 26);
        arrayListJadwal.add(new Jadwal(alfurqon, calendar.getTime()));
        calendar.set(2016, Calendar.JULY, 1);
        arrayListJadwal.add(new Jadwal(almanar1, calendar.getTime()));
        calendar.set(2016, Calendar.APRIL, 22);
        arrayListJadwal.add(new Jadwal(almanar2, calendar.getTime()));
        calendar.set(2016, Calendar.MAY, 27);
        arrayListJadwal.add(new Jadwal(almanar3, calendar.getTime()));
        calendar.set(2016, Calendar.MAY, 20);
        arrayListJadwal.add(new Jadwal(annurr, calendar.getTime()));
        calendar.set(2016, Calendar.MAY, 13);
        arrayListJadwal.add(new Jadwal(alikhlas, calendar.getTime()));
        calendar.set(2016, Calendar.MAY, 6);
        arrayListJadwal.add(new Jadwal(almanar1, calendar.getTime()));

        arrayListJadwalLewat = new ArrayList<>();
        arrayListJadwalAkanDatang = new ArrayList<>();
        for (Jadwal jadwal: arrayListJadwal) {
            if (jadwal.getDate().before(Calendar.getInstance().getTime())) arrayListJadwalLewat.add(jadwal);
            else arrayListJadwalAkanDatang.add(jadwal);
        }
        Collections.sort(arrayListJadwalAkanDatang);
        Collections.sort(arrayListJadwalLewat, Collections.<Jadwal>reverseOrder());
    }

    @BindView(R.id.tab_layout) TabLayout tabLayout;
    @BindView(R.id.view_pager) ViewPager viewPager;

    public static String DATA_ITEM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Fitur ini masih belum jadi", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());

        pagerAdapter.addFragment(JadwalFragment.newInstance(JadwalFragment.NOT_PASSED), "Soon");
        pagerAdapter.addFragment(JadwalFragment.newInstance(JadwalFragment.PASSED), "Passed");

        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        setupDummyData();
    }

    @Override
    public void onListFragmentInteraction(Jadwal item) {
        // handle navigation on item click
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DATA_ITEM, item);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    class PagerAdapter extends FragmentPagerAdapter{
        private List<Fragment> fragments;
        private List<String> tabNames;
        public PagerAdapter(FragmentManager fm) {
            super(fm);
            fragments = new ArrayList<>();
            tabNames = new ArrayList<>();
        }

        public void addFragment(Fragment fragment, String title){
            fragments.add(fragment);
            tabNames.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            // Generate title based on item position
            return tabNames.get(position);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}
