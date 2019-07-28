<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cool Crypto</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body bgcolor="#616161">

    <center>
        <h1><font color="#87b2e0">Marius's Cryptography Web App</font></h1>
        <br/>

        <img src="img/logo3.png" size="25%"/>

        <p>
            <strong><font color="#87b2e0">This is a web app that encrypts and decrypts secret messages that you can send to your friends!</font></strong>
        </p>

        <br/>

        <form method="post" action="crypto">

        <table width="800" border="0">
            <tr>
                <td colspan="3" align="center">
                    <textarea name="cryptoInput" rows="12" cols="120" placeholder="Type or Paste in text here..."></textarea>
                </td>
            </tr>
            <tr>
                <td colspan="3">

                        <br/>
                    <div class="custom-select" style="width:200px;">
                        <select name="encryptionType" size="1">
                            <option>- Select Encryption -</option>
                            <option value="simple">Simple</option>
                            <option value="advanced">Advanced</option>
                        </select>
                        </div>

                    <br/><br/>

                </td>
            </tr>
            <tr>
                <td align="center">
                    <button type="submit" name="encryptButton">Encrypt</button>
                </td>
                <td align="center">
                    <button type="submit" name="decryptButton">Decrypt</button>
                </td>
                <td align="center">
                    <button>Clear</button>
                </td>
            </tr>
            <tr>
                <td colspan="3">
                    <br/><br/>
                    <textarea rows="12" cols="120">${textareaOutput}</textarea>
                </td>
            </tr>
        </table>

            </form>
    </center>
    <script src="script.js"> </script>
</body>
</html>