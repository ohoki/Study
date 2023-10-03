const fruit = ['🍌', '🍎', '🍊', '🍇'];

//배열 아이템을 참조하는 방법
console.log(fruit[0]);
console.log(fruit[1]);
console.log(fruit[2]);
console.log(fruit[3]);
console.log(fruit.length);

for (let i = 0; i < fruit.length; i++) {
  console.log(fruit[i]);
}

//추가, 삭제 - 좋지 않은 방식 (❌❌)
fruit[6] = '🍓';
console.log(fruit);

delete fruit[1];
console.log(fruit);
//아이템만 삭제되고 자리는 남아 있음 
//[ '🍌', <1 empty item>, '🍊', '🍇', <2 empty items>, '🍓' ]
