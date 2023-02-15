# airports-search

Требуется написать консольное Java-приложение (JDK 11), позволяющее быстро искать 
данные аэропортов по вводимому пользователем тексту.

Данные для программы берутся из файла . В нем находится таблица аэропортов 
со свойствами в формате CSV. За что отвечает каждая колонка – не важно

После запуска программа выводит в консоль предложение ввести текст. Например, 
пользователь вводит «Bo» и нажимает «Enter». Программа выводит список всех строк из 
файла , вторая колонка которых начинается на «Bo», отсортированных по этой 
колонке в формате « ». 

Для строковых колонок, значения которых заключены в кавычки, должен быть 
лексикографический порядок, а для числовых — числовой. Не буквенные и не цифровые 
символы также участвуют в поиске. Регистр букв не имеет значения.