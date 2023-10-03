// 얕은 복사 Shallow Copy - 객체는 메모리 주소 전달 때문
// 자바스크립트에서 복사할때는 항상 얕은 복사가 이루어짐!
// Array.from, concat, slice, spread(...), Object.assign 모두 얕은 복사가 됨

const pizza = { name: '🍕', price: 3 };
const ramen = { name: '🍜', price: 1 };
const sushi = { name: '🍣', price: 2 };
const store1 = [pizza, ramen];
const store2 = Array.from(store1);
console.log('store1', store1);
console.log('store2', store2);

store2.push(sushi); // store1에는 sushi가 추가되지 않고 store2에만 추가됨
console.log('store1', store1);
console.log('store2', store2);

pizza.price = 4; // store1, store2의 피자 가격 다 바뀜
console.log('store1', store1);
console.log('store2', store2);
