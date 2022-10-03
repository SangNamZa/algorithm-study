function solution(lottos, win_nums) {
        let a = 0;
        let b = 0;
        let c = 0;
        let rankA = 6;
        let rankB = 6;


        win_nums.map((winnum) => {
          if (lottos.includes(winnum)) {
            a += 1;
          }
        });

        for (const obj of lottos) {
          if (obj === 0) {
            c += 1;
          }
        }

        if (a + c === 6) {
          rankA = 1;
        }
        if (a + c === 5) {
          rankA = 2;
        }
        if (a + c === 4) {
          rankA = 3;
        }
        if (a + c === 3) {
          rankA = 4;
        }
        if (a + c === 2) {
          rankA = 5;
        }
        if (a + c === 1) {
          rankA = 6;
        }
        if (a + c === 0) {
          rankA = 6;
        }

        if (a === 6) {
          rankB = 1;
        }

        if (a === 5) {
          rankB = 2;
        }

        if (a === 4) {
          rankB = 3;
        }

        if (a === 3) {
          rankB = 4;
        }

        if (a === 2) {
          rankB = 5;
        }

        if (a === 1) {
          rankB = 6;
        }

        if (a === 0) {
          rankB = 6;
        }

        var answer = [rankA, rankB];

        return answer;
      }
