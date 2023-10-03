const map = new Map([
  ['key1', '🍎'],
  ['key2', '🍌']
]);
console.log(map);

// 사이즈
console.log(map.size);
// 존재하는지 확인
console.log(map.has('key1'));
console.log(map.has('key6'));
// 순회
map.forEach((value, key) => console.log(key, value));
// 찾기
console.log(map.get('key1'));
console.log(map.get('key6'));
// 추가
map.set('key3', '🥝');
console.log(map);
// 삭제
map.delete('key3');
console.log(map);
// 전부삭제
map.clear();
console.log(map);

//오브젝트와의 큰 차이점??
const key = { name: 'milk', price: 10};
const milk = { name: 'mike', price: 10, description: '맛있는우유'};
const obj = {
  [key]: milk,
};
console.log(obj); 
//{ '[object Object]': { name: 'mike', price: 10, description: '맛있는우유' }}
const map2 = new Map([[key, milk]]);
console.log(map2);
//{ name: 'milk', price: 10 } => { name: 'mike', price: 10, description: '맛있는우유' }}

//map과 오브젝트는 비슷해보이지만 사용할 수 있는 함수(인터페이스)가 살짝 다르다