const x = 0;
const y = 0;

const coordinate = {x , y}; // {x: x, y: y}; 의 축약버전
//키 이름과 참조하고 있는 변수의 이름이 같은 경우에는 축약 가능!!
console.log(coordinate);

function makeObj(name, age) {
  return {
    name, // name: name,
    age,  // age: age, 와 같다!!
  }
}