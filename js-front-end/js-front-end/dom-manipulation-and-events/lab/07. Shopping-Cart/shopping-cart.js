document.addEventListener('DOMContentLoaded', solve);

function solve() {
   const products = document.querySelectorAll('.product');
   const textarea = document.querySelector('textarea');
   const checkoutButton = document.querySelector('.checkout');

   let cart = new Map();

   products.forEach((product) => {
      const addButton = product.querySelector('.add-product');
      const productName = product.querySelector('.product-title').textContent;
      const productPrice = parseFloat(
         product.querySelector('.product-line-price').textContent
      );

      addButton.addEventListener('click', () => {
         if (cart.has(productName)) {
            cart.set(productName, {
               price: productPrice,
               quantity: cart.get(productName).quantity + 1,
            });
         } else {
            cart.set(productName, { price: productPrice, quantity: 1 });
         }

         textarea.value += `Added ${productName} for ${productPrice.toFixed(2)} to the cart.\n`;
      });
   });

   checkoutButton.addEventListener('click', () => {
      let totalPrice = 0;
      const uniqueProducts = [];
      cart.forEach((value, key) => {
         totalPrice += value.price * value.quantity;
         uniqueProducts.push(key);
      });

      textarea.value += `You bought ${uniqueProducts.join(', ')} for ${totalPrice.toFixed(2)}.\n`;

      document.querySelectorAll('button').forEach((button) => {
         button.disabled = true;
      });
   });
}
