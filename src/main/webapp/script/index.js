 function btn(name) {
     if (name == bookList) {
         document.getElementById('readersList').style.display = 'none';
         document.getElementById('bookList').style.display = 'block';

     } else {
         document.getElementById('readersList').style.display = 'block';
         document.getElementById('bookList').style.display = 'none';

     }
 }