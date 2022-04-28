className = "ChangeMeInputs"

fields = []
while True:
    try:
        newField = input('')
        if len(newField) > 0:
            for part in newField.split('\n'):
                fields.append(newField.strip())
        else:
            break
    except EOFError:
        break

print(f'public static class {className} implements LoggableInputs {{')
for field in fields:
    print(f'public {field} = 0.0;')

print('@Override')
print('public void toLog(LogTable table) {')
for field in fields:
    varName = field.split(' ')[-1]
    print(f'\ttable.put("{varName}", {varName});')
print('}\n')

print('@Override')
print('public void fromLog(LogTable table) {')
for field in fields:
    varName = field.split(' ')[-1]
    print(f'\t{varName} = table.getDouble("{varName}", {varName});')
print('}\n}')