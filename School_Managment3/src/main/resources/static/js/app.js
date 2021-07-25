//Menu
const $menuIcon = document.getElementById('menu-icon')
const $menu = document.getElementById('menu')
//Modal
const openEls = document.querySelectorAll("[data-open]");
const closeEls = document.querySelectorAll("[data-close]");
const cancelEls = document.querySelectorAll("[data-cancel]");
//Close alert
let $closeAlert = document.getElementById('close-alert')
let $alert = document.getElementById('alert-dismissable')

if($closeAlert == null ){
  $closeAlert = "sin msg, esperando a enviar el form"  
}else {
  $closeAlert.addEventListener('click',()=> {
    $alert.classList.add('alert-dn')
  })
}

$menuIcon.addEventListener('click',()=> {
    $menu.classList.toggle('menu--show')
})

for (const el of openEls) {
  el.addEventListener("click", function() {
    const modalId = this.dataset.open;
    //console.log(modalId)
    document.getElementById(modalId).classList.add('modal--show');
    console.log("hii");
  });
}

for (const el of closeEls) {
  el.addEventListener("click", function() {	
    this.parentElement.parentElement.parentElement.classList.remove('modal--show');
	//console.log(this.parentElement.parentElement.parentElement);
  });
}

for (const el of cancelEls) {
  el.addEventListener("click", function(e) {	
	e.preventDefault();
    this.parentElement.parentElement.parentElement.parentElement.classList.remove('modal--show');
	//console.log(this.parentElement.parentElement.parentElement.parentElement);
  });
}
