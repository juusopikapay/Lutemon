public class MyPagerAdapter extends FragmentPagerAdapter {

    private static final int NUM_TABS = 3;

    public MyPagerAdapter(FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new TrainingFragment();
            case 2:
                return new BattleFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_TABS;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }

    public View getTabView(int position) {
        View tabView = LayoutInflater.from(getContext()).inflate(R.layout.tab_layout, null);
        TextView tabText = tabView.findViewById(R.id.tab_text);
        tabText.setText(getPageTitle(position));
        LinearLayout tabLayout = tabView.findViewById(R.id.tab_layout);
        if (position == 0) {
            tabLayout.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.blue));
            tabText.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
        } else {
            tabLayout.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.white));
            tabText.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
        }
        return tabView;
    }
}
