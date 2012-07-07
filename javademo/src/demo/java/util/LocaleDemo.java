package demo.java.util;

import java.util.Arrays;
import java.util.Locale;

public class LocaleDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Locale locale = new Locale("zh", "CN", "WIN");
        System.out.println("Locale:" + locale + ", DisplayName:" + locale.getDisplayName());
        System.out.println("Country:" + locale.getCountry() + ", DisplayCountry:" + locale.getDisplayCountry() + ", ISO3Country:"
                + locale.getISO3Country());
        System.out.println("Language:" + locale.getLanguage() + ", DisplayLanguage:" + locale.getDisplayLanguage() + ", ISO3Language:"
                + locale.getISO3Language());
        System.out.println("Variant:" + locale.getVariant() + ", DisplayVariant:" + locale.getDisplayVariant());

        Locale defaultLocale = Locale.getDefault();
        System.out.println("local:" + defaultLocale + ", language:" + defaultLocale.getLanguage() + ", county:" + defaultLocale.getCountry());

        Locale[] availableLocales = Locale.getAvailableLocales();
        System.out.println("Have " + availableLocales.length + " availableLocales:");
        System.out.println("\t" + Arrays.toString(availableLocales));

        String[] isoLanguages = Locale.getISOLanguages();
        System.out.println("Have " + isoLanguages.length + " ISOLanguages:");
        System.out.println("\t" + Arrays.toString(isoLanguages));

        String[] isoCountries = Locale.getISOCountries();
        System.out.println("Have " + isoCountries.length + " ISOCountries:");
        System.out.println("\t" + Arrays.toString(isoCountries));

    }

}
