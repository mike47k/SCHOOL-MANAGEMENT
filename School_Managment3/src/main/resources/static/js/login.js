//Visibility-login
const $pwd = document.getElementById('pwd')
const $iPwd = document.getElementById('contraseña')

$pwd.addEventListener('click',()=> {
    let atributo = $iPwd.getAttribute("type")
  
    console.log(atributo)
    if(atributo=="password"){
        $iPwd.setAttribute("type","text")
        console.log($pwd.classList);
        console.log($pwd.classList.replace("fa-eye","fa-eye-slash"))
        
    }else {
        console.log($pwd.classList.replace("fa-eye-slash","fa-eye"))
        $iPwd.setAttribute("type","password")
    }
  })
