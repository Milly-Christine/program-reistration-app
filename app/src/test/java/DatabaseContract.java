import android.provider.BaseColumns;

public final class DatabaseContract {
    private DatabaseContract() {
    }

    public static class RegistrationEntry implements BaseColumns {
        public static final String TABLE_NAME = "registration";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_EMAIL = "email";
    }
}
