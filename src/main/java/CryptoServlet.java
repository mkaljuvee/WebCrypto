import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "CryptoServlet",
        urlPatterns = "/crypto"
)

public class CryptoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String inputText = req.getParameter("cryptoInput");
        String encryptionType = req.getParameter("encryptionType");

        boolean simpleSelected = encryptionType.equals("simple");
        boolean advancedSelected = encryptionType.equals("advanced");
        boolean encryptButtonClicked = req.getParameter("encryptButton") != null;
        boolean decryptButtonClicked = req.getParameter("decryptButton") != null;
        String textareaOutput = "";
        Crypto crypto = null;

        if(simpleSelected) {
            crypto = new SimpleCrypto();
        } else if(advancedSelected) {
            crypto = new AdvancedCrypto();
        }
        textareaOutput = getCryptoOutput(crypto, inputText, encryptButtonClicked, decryptButtonClicked);

        req.setAttribute("textareaOutput", textareaOutput);
        RequestDispatcher view = req.getRequestDispatcher("index.jsp");
        view.forward(req, resp);
    }

    public String getCryptoOutput(Crypto crypto, String inputText, boolean encrypt, boolean decrypt) {
        if(encrypt) {
            String encryptedText = crypto.encrypt(inputText);
            System.out.println("Encrypted: " + encryptedText);
            return encryptedText;

        } else if(decrypt) {
            String decryptedText = crypto.decrypt(inputText);
            System.out.println("Decrypted: " + decryptedText);
            return decryptedText;
        } else {
            return "";
        }
    }
}
