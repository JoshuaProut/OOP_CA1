
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

    out_string = "ModuleDescriptor {} = new ModuleDescriptor(\"{}\", \"{}\", new double[] {});".format(module_code, module_code, module_name, CA_weights)
    #out_string = "uni.addModuleDescriptor({})".format(module_code)
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
    marks = line_split[4]
    marks = marks.replace("[","{")
    marks = marks.replace("]","}")
    marks = marks.replace(" \n","")

    out_string1 = "student = uni.getStudentBy({});".format(ID)
    out_string2 = "record = new StudentRecord(student, module, new double[]{});".format(marks) 
    out_string3 = "module.addRecord(record);".format(marks)
    out_string4= "student.addRecord(record);".format(marks)
    print(out_string1)
    print(out_string2)
    print(out_string3)
    print(out_string4)
    


    
