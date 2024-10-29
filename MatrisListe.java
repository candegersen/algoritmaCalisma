
public class MatrisListe {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        // dp matrisindeki desenlerin eşleşip eşleşmediğini bulmak için
        boolean[][] dp = new boolean[m + 1][n + 1]; // dp matrisini tanımlama

        // Sıfır uzunluktaki string ile sıfır uzunluktaki pattern eşleşir.
        dp[0][0] = true;

        // dp matrisini doldurmak için
        for (int j = 2; j <= n; j++) {
            // j döngü değişkenidir, j'nin n değişkeninden küçük veya ona eşit olması lazımdır ki, j++ devam etsin.
            if (p.charAt(j - 1) == '*') {
                // * karakteri kendisinden önceki karakterin 0 kez bulunmasını gösterir.
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char currentS = s.charAt(i - 1);
                char currentP = p.charAt(j - 1);
                // indeks 0'dan başladığı ve her bir array uzunluğu -1 olduğu için i-1 ve j-1 kullanılır.

                if (currentP == '.' || currentP == currentS) {
                    // Eğer her iki karakterde eşleşiyorsa (ya da currentP . ise)
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (currentP == '*') {
                    // * ya bir önceki karakterle ya da birden fazla karakterle eşleşmesi gerekir
                    dp[i][j] = dp[i][j - 2]; // * karakteri kendisinden önce eşleşen bulunmadığı için durur.

                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == currentS) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }

        // Sonuç: s'nin p'ye eşleşip eşleşmediği
        return dp[m][n];
    }
}
