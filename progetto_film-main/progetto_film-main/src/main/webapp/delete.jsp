<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Elimina Film</title>
    <script>
        function deleteFilm() {
            const filmId = document.getElementById("filmId").value;

            fetch(`/api/conn/delete/${filmId}`, {
                method: "DELETE",
                headers: {
                    "Content-Type": "application/json"
                }
            })
            .then(response => {
                if (response.status === 204) {
                    alert("Film eliminato con successo!");
                } else {
                    alert("Errore durante l'eliminazione del film. Codice: " + response.status);
                }
            })
            .catch(error => {
                console.error("Errore fetch:", error);
            });
        }
    </script>
</head>
<body>
<h2>Elimina un film</h2>
<form onsubmit="event.preventDefault(); deleteFilm();">
    <label>ID del film da eliminare: <input type="number" id="filmId" required/></label><br/>
    <button type="submit">Elimina</button>
</form>
</body>
</html>
