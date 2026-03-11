import numpy as np
import matplotlib.pyplot as plt
from matplotlib import pyplot as plt
x=[10,20,30,40,50,60]
y=np.linspace(0,np.pi,6)
sinx=np.sin(y)
plt.title("line chart",fontsize=15,fontweight="bold",color="blue")
plt.xlabel("x-axis")
plt.ylabel("y-axis")
plt.plot(x,y)
plt.show()