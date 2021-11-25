package codewars;

public class WhoLikesIt {

    public static String whoLikesIt(String... names) {
        //Do your magic here
        if (names.length == 0) {
            return "no one likes this";
        } else if (names.length == 1) {
            return names[0] + " likes this";
        } else if (names.length == 2) {
            return names[0] + " and " + names[1] + " like this";
        } else if (names.length == 3) {
            return names[0] + ", " + names[1] + " and " + names[2] + " like this";
        } else {
            int num = names.length - 2;
            return names[0] + ", " + names[1] + " and " + num + " others like this";
        }
    }

    public static String whoLikesIt2(String... names) {
        final String Template1 = "%s likes this";
        final String Template2 = "%s and %s like this";
        final String Template3 = "%s, %s and %s like this";
        final String TemplateN = "%s, %s and %d others like this";
        return
                names.length == 0 ? "no one likes this" :
                        names.length == 1 ? String.format(Template1, names[0]) :
                                names.length == 2 ? String.format(Template2, names[0], names[1]) :
                                        names.length == 3 ? String.format(Template3, names[0], names[1], names[2]) :
                                                String.format(TemplateN, names[0], names[1], names.length - 2);
    }
}
