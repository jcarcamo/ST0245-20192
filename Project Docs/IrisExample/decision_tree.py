#!/bin/python
import numpy as np
#import graphviz
from sklearn.datasets import load_iris
from sklearn import tree
from sklearn.tree.export import export_text

iris = load_iris()
print (iris.feature_names)
print (iris.target_names)

print (iris.data[0])
print (iris.target[0])

#for i in range(len(iris.target)):
#    print("Example %d: label %s, features %s" % (i,iris.target[i], iris.data[0]))

test_idx = [0,50,100]

# train data
train_target = np.delete(iris.target, test_idx)
train_data = np.delete(iris.data, test_idx, axis=0)

# test data
test_target = iris.target[test_idx]
test_data = iris.data[test_idx]

classifier = tree.DecisionTreeClassifier()
classifier.fit(train_data, train_target)

print(test_target)
print(classifier.predict(test_data))


#dot_data = tree.export_graphviz(classifier, out_file=None, 
#                feature_names=iris.feature_names,  
#                class_names=iris.target_names,  
#                filled=True, rounded=True,  
#                special_characters=True)

#graph = graphviz.Source(dot_data)
#graph.render("iris") 

print (iris.feature_names, iris.target_names)
print (test_data[0], test_target[0])
print (test_data[1], test_target[1])
print (test_data[2], test_target[2])

r = export_text(classifier, feature_names=iris['feature_names'])
print("\n\n Text Decision Tree\n ******************\n") 
print(r)

