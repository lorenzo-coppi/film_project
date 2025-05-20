<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Elimina Film</title>
	<style>
	        body {
	            background-color: #141414;
	            font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
	            color: #ffffff;
	            margin: 0;
	            padding: 0;
	            display: flex;
	            justify-content: center;
	            align-items: center;
	            min-height: 100vh;
	        }

	        form {
	            background-color: #1f1f1f;
	            padding: 40px;
	            border-radius: 10px;
	            box-shadow: 0 0 15px rgba(0,0,0,0.5);
	            width: 100%;
	            max-width: 500px;
	        }

	        h2 {
	            text-align: center;
	            margin-bottom: 30px;
	            color: #e50914;
	        }

	        label {
	            display: block;
	            margin-bottom: 15px;
	        }

	        input {
	            width: 100%;
	            padding: 10px;
	            margin-top: 5px;
	            border-radius: 4px;
	            border: none;
	            background-color: #333;
	            color: #fff;
	        }

	        input:focus {
	            outline: none;
	            background-color: #444;
	        }

	        button {
	            width: 100%;
	            padding: 12px;
	            background-color: #e50914;
	            border: none;
	            border-radius: 5px;
	            font-size: 16px;
	            color: white;
	            cursor: pointer;
	            margin-top: 20px;
	        }

	        button:hover {
	            background-color: #f40612;
	        }
	    </style>
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

<form onsubmit="event.preventDefault(); deleteFilm();">
	<h2>Elimina un film</h2>
    <label>ID del film da eliminare: <input type="number" id="filmId" required/></label><br/>
    <button type="submit">Elimina</button>
</form>
</body>
</html>
