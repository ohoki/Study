class Booking {
  #show;
  #date;
  constructor(show, date) {
    this.#show = show;
    this.#date = date;
  }

  get hasTalkback() {
    return this.#show.hasOwnProperty('talkback') && !this.isPeakDay;
  }

  get basePrice() {
    let result = this.#show.price;

    if (this.isPeakDay) {
      result += Math.round(result * 0.15);
    }

    return result;
  }
}

class PremiumBooking extends Booking {
  constructor(show, date, extras) {
    super(show, date);
    this._extras = extras;
  }

  get hasTalkback() {
    return this._show.hasOwnProperty('talkback');
  }

  get basePrice() {
    return Math.round(super.basePrice + this._extras.PremiumFee);
  }

  get hasDinner() {
    return this._extras.hasOwnProperty('dinner') && !this.isPeakDay;
  }
}

const booking = new Booking(show, date);
const premiumBooking = new PremiumBooking(show, date, extras);
