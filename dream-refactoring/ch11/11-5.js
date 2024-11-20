export class Order {
  constructor(quantity, itemPrice) {
    this.quantity = quantity;
    this.itemPrice = itemPrice;
  }

  get basePrice() {
    return this.quantity * this.itemPrice;    
  }
 
  get finalPrice() {
    return this.discountedPrice();
  }

  get discountLevel() {
    return this.quantity > 100 ? 2 : 1;
  }

  discountedPrice() {
    switch (this.discountLevel) {
      case 1:
        return this.basePrice * 0.95;
      case 2:
        return this.basePrice * 0.9;
    }
  }
}
