#include <cstdio>
#include <cstring>

const int maxN = 10;

bool used[maxN];
int perm[maxN];

void search (int N)
{
  static int is[maxN];
  memset(used, false, N);
  int lv = 0;
  is[lv] = -1;
  while (lv >= 0)
  {
    int &i = is[lv];
    if (i != -1)
      used[i] = false;
    ++i;
    while (i < N && used[i])
      ++i;
    if (i == N)
      --lv;
    else
    {
      perm[lv] = i;
      used[i] = true;
      if (lv < N - 1)
        is[++lv] = -1;
      else
      {
        for (int j = 0; j < N; ++j)
          printf("%d%c", perm[j], j < N - 1 ? ' ' : '\n');
      }
    }
  }
}

int main ()
{
  search(4);
}
