H, M = map(int, input().split())

if M >= 45 :
    print(H, M-45)

elif M < 45 :
    if H-1 < 0:
        H = 24
    print(H-1, M-45+60)