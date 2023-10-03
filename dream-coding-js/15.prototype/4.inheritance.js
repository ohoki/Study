// 객체지향 프로그래밍의 장점
// 상속을 통한 코드의 재사용성~~!!

//프로토타입을 베이스로 한 객체지향 프로그래밍
function Animal(name, emoji) {
  this.name = name;
  this.emoji = emoji;
};

Animal.prototype.printName = function() {
  console.log(`${this.name} ${this.emoji}`);
};

function Dog(name, emoji, owner) {
  Animal.call(this, name, emoji); // super(name, emoji) 와 같은 효과
  this.owner = owner;
};
Dog.prototype = Object.create(Animal.prototype);
//Animall에 있는 프로토타입을 베이스로 Dog에 새로운 오브젝트를 만들어줌

Dog.prototype.play = function() {
  console.log('같이 놀자 닝겐!');
};

const dog1 = new Dog('멍멍', '🐶', '영호');
dog1.play();
dog1.printName();

function Tiger(name, emoji) {
  Animal.call(this, name, emoji);
};
Tiger.prototype = Object.create(Animal.prototype);
Tiger.prototype.hunt = () => {
  console.log('사냥한다 냠냠');
};
const tiger1 = new Tiger('어흥', 'ㅎㅎ');
tiger1.hunt();


//instanceof - 객체가 누구를 상속하는지 어떤 클래스 또는 생성자 함수의 인스턴스인지
//확인할 수 있음
console.log(dog1 instanceof Dog);
console.log(dog1 instanceof Animal);
console.log(dog1 instanceof Tiger);