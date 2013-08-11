#include <cstdio>

const int maxN = 10;

int N;
bool used[maxN];
int perm[maxN];

void search ()
{
  static int is[maxN];
  int lv = 0;
  is[lv] = -1;
  while (true)
  {
    int &i = is[lv];
    if (i == -1)
    {
      if (lv == N)
      {
        for (int j = 0; j < N; ++j)
          printf("%d%c", perm[j], j < N - 1 ? ' ' : '\n');
        i = N;
      }
      else
        i = 0;
    }
    if (i == N)
    {
      if (lv == 0)
        break;
      --lv;
      int &i2 = is[lv];
      used[i2] = false;
      ++i2;
    }
    else
    {
      while (i < N && used[i])
        ++i;
      if (i < N)
      {
        perm[lv] = i;
        used[i] = true;
        ++lv;
        is[lv] = -1;
      }
    }
  }
}

int main ()
{
  N = 4;
  search();
}
