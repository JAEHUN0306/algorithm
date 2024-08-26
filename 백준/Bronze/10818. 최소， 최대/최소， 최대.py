n = int(input())

n_list = list(map(int, input().split()))
print("{} {}".format(min(n_list), max(n_list)))