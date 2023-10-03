// const apple = {
//   name: 'apple',
//   display: function() {
//     console.log(`${this.name}: 🍎`); 
//   }
// }

// const orange = {
//   name: 'orange',
//   display: function() {
//     console.log(`${this.name}: 🍊`); 
//   }
// }


//생성자 함수 (함수의 이름은 대문자로 시작해야한다)
//템플릿을 만들어두고 형식이 같은(속성은 다른)함수를 찍어낼 수 있다.

function Fruit (name, emoji) {
  this.name = name,
  this.emoji = emoji;
  this.display = function() {
    console.log(`${this.name}: ${this.emoji}`);
  };
  return this;   //생략가능함 (생략하면 자동으로 return this; 라고 인식함)
};

const apple = new Fruit('apple', '🍎');
const orange = new Fruit('orange', '🍊');


console.log(apple);
console.log(orange);

//클래스로 좀 더 우아하게 만들수 있다~!