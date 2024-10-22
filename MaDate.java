import java.util.Scanner;

class MaDate {
    private int jours;
    private int mois;
    private int annee;

    // q2: Overriding toString method
    public String toString() {
        return jours + "/" + mois + "/" + annee;
    }

    // q3: Getter methods
    public int getJours() {
        return jours;
    }

    public int getMois() {
        return mois;
    }

    public int getAnnee() {
        return annee;
    }

    // Setter methods
    public void setJours(int j) {
        jours = j;
    }

    public void setMois(int m) {
        mois = m;
    }

    public void setAnnee(int a) {
        annee = a;
    }

    // q4: Constructor
    public MaDate(int jours, int mois, int annee) {
        this.jours = jours;
        this.mois = mois;
        this.annee = annee;
    }

    // q5: Constructor with only year
    public MaDate(int annee) {
        this(1, 1, annee); // Default to Jan 1st of that year
    }

    // q6: Adding a day
    public void ajouterUnJour() {
        jours++;
        if (jours > nbJours(mois, annee)) {
            jours = 1;
            mois++;
        }
        if (mois > 12) {
            mois = 1;
            annee++;
        }
    }

    // Determine number of days in a month
    public int nbJours(int mois, int annee) {
        switch (mois) {
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                if (estBissextile(annee)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return 31;
        }
    }

    // Check if the year is a leap year
    public boolean estBissextile(int annee) {
        return (annee % 4 == 0 && annee % 100 != 0) || (annee % 400 == 0);
    }

    // q7: Adding multiple days
    public void ajouterPlusieursJours(int n) {
        for (int i = 0; i < n; i++) {
            ajouterUnJour();
        }
    }

    // q8: Adding a month
    public void ajouterUnMois() {
        mois++;
        if (mois > 12) {
            mois = 1;
            ajouterUnAn();
        }
    }

    // Adding a year
    public void ajouterUnAn() {
        annee++;
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MaDate date1 = new MaDate(1, 1, 2024);
        MaDate date2 = new MaDate(1, 1, 2023);
        MaDate date3 = new MaDate(2025);

        date1.setJours(10);
        date1.setMois(5);
        date1.setAnnee(2022);

        date2.setJours(21);
        date2.setMois(12);

        System.out.println("Date 1: " + date1);
        System.out.println("Date 2: " + date2);
        System.out.println("Date 3: " + date3);

        System.out.println("\nQuel type d'opération souhaitez-vous effectuer ?");
        System.out.println("1. Ajout d'un jour");
        System.out.println("2. Ajout de plusieurs jours");
        System.out.println("3. Ajout d'un mois");
        System.out.println("4. Ajout d'une année");
        System.out.print("Entrez votre choix : ");
        int choix = scanner.nextInt();

        System.out.println("\nSur quelle date souhaitez-vous effectuer l'opération ?");
        System.out.println("1. Date 1");
        System.out.println("2. Date 2");
        System.out.println("3. Date 3");
        System.out.print("Entrez votre choix : ");
        int choixDate = scanner.nextInt();

        MaDate dateChoisie;
        switch (choixDate) {
            case 1:
                dateChoisie = date1;
                break;
            case 2:
                dateChoisie = date2;
                break;
            case 3:
                dateChoisie = date3;
                break;
            default:
                System.out.println("Choix invalide.");
                return;
        }

        switch (choix) {
            case 1:
                dateChoisie.ajouterUnJour();
                break;
            case 2:
                System.out.print("Entrez le nombre de jours à ajouter : ");
                int jours = scanner.nextInt();
                dateChoisie.ajouterPlusieursJours(jours);
                break;
            case 3:
                dateChoisie.ajouterUnMois();
                break;
            case 4:
                dateChoisie.ajouterUnAn();
                break;
            default:
                System.out.println("Choix invalide.");
                return;
        }

        System.out.println("\nDate après l'opération : " + dateChoisie);
    }
}
