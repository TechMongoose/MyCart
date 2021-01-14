function add_to_cart(pid, pname, price) {

    let cart = localStorage.getItem("cart");
    if (cart == null) {
        //no cart yet
        let products = [];
        let product = {productId: pid, productName: pname, productQuantity: 1, productPrice: price};
        products.push(product);
        localStorage.setItem("cart", JSON.stringify(products));
        console.log("product is added for the first time");
    } else {
        //cart is already present
        let pcart = JSON.parse(cart);
        
        let oldProduct = pcart.find((item) => item.productId == pid);
        if(oldProduct){
            // we have to increase the quantity
            oldProduct.productQuantity = oldProduct.productQuantity + 1;
            pcart.map((item) => {
               if(item.productId == oldProduct.productId){
                  item.productQuantity  = oldProduct.productQuantity; 
               } 
            });
            localStorage.setItem("cart", JSON.stringify(pcart));
            console.log("product quantity is increased");
        }else{
            //we have to add the product
            let product = {productId: pid, productName: pname, productQuantity: 1, productPrice: price};
            pcart.push(product);
            localStorage.setItem("cart", JSON.stringify(pcart));
            console.log("product is added");
        }
    }
}


