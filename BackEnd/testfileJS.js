const btnsubir = document.querySelector("#btnSubir");
const file = document.querySelector("#archivo");
//local
//let url="http://localhost:8082/files/upload";
//deploy
let url="https://nocountry-production-78d6.up.railway.app/files/upload";

//Se le da el nombre al archivo



btnsubir.addEventListener("click", (e) => {
  e.preventDefault();
  let nombre=document.getElementById("nombre").value;
  const formData = new FormData();
  formData.append("file", file.files[0], nombre);
  fetch(url, {
    method: "POST",
    body: formData
  })
    .then((res) => res.text())
    .then((data) => console.log(data))
    .catch((err) => console.log(err));
});
