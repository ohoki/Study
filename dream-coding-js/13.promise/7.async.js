function getBanana() {
  return new Promise((resolve) => {
    setTimeout(() => {
      resolve('🍌');
    }, 1000)
  });
};

function getApple() {
  return new Promise((resolve) => {
    setTimeout(() => {
      resolve('🍎');
    }, 3000)
  });
};

function getOrange() {
  return Promise.reject(new Error('no orange'));
};

//바나나와 사과를 같이 가지고 와서 배열로 정리
//비동기 코드를 동기적으로 async, await 
async function fetchFruits() {
  const banana = await getBanana();
  const apple = await getApple();
  return [apple, banana];
}

fetchFruits()
  .then((fruits) => console.log(fruits));