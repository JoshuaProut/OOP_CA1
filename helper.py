
with open("module_descriptors.csv","r") as file:
    lines = file.readlines()
    #print(lines)

for line in lines:
    line_split = line.split(", ")
    #print(line_split)
    module_name = line_split[0]
    module_code = line_split[1]
    CA_weights = line_split[2]
    CA_weights = CA_weights.replace("[","{")
    CA_weights = CA_weights.replace("]","}")
    CA_weights = CA_weights.replace("  \n","")
    
    #print(CA_weights)

    out_string = "uni.addModuleDescriptor(new ModuleDescriptor(\"{}\", \"{}\", new double[] {}));".format(module_name, module_code, CA_weights)
    print(out_string)


with open("Students.csv","r") as file:
    lines = file.readlines()
    #print(lines)

for line in lines:
    line_split = line.split(", ")
    #print(line_split)
    student_id = line_split[0]
    student_name = line_split[1]
    student_gender = line_split[2]
    student_gender = student_gender.replace(" \n","")

    out_string = "uni.addStudent(new Student({}, \"{}\", \'{}\'));".format(student_id, student_name, student_gender)
    print(out_string)
    

with open("module.csv","r") as file:
    lines = file.readlines()
    #print(lines)

for line in lines:
    line_split = line.split(", ")
    #print(line_split)
    ID = line_split[0]
    marks = line_split[3]
    marks = marks.replace("[","{")
    marks = marks.replace("]","}")
    marks = marks.replace(" \n","")

    out_string1 = "student = uni.getStudentByID({});".format(ID)
    out_string2 = "module.addRecord(student, module, {}));".format(marks)
    out_string3 = "student.addRecord(student, module, {}));".format(marks)
    print(out_string1)
    print(out_string2)
    print(out_string3)

    


    
