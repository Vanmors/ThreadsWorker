Надо написать программу, в которой 6 тредов: Chandler, Joey, Monica, Phoebe, Rachel и Ross разыгрывают в консоли сценки из ситкома. Каждый печатает свое имя и реплику. Например, так:
Сценка дана в тексте такого формата:  

```text
Monica: Well, what's the job?  
Rachel: Assistant buyer. Oh! I would be shopping... for a living!
```

Сценка дана в тексте такого формата:  
```text
Joey: Hey, hey.  
Chandler: Hey.  
Phoebe: Hey.  
chandler: And this from the cry-for-help department. Are you wearing makeup?  
Joey: Yes, I am. As of today, I am officially Joey Tribbiani, actor slash model.  
Chandler: That's so funny, 'cause I was thinking you look more like Joey Tribbiani, man slash woman.  
Phoebe: What were you modeling for?  
Joey: You know those posters for the city Free Clinic?  
Monica: Oh, wow, so you're gonna be one of those "healthy, healthy, healthy guys"?  
Phoebe: You know, the asthma guy was really cute.  
Chandler: Do you know which one you're gonna be?  
Joey: No, but I hear lyme disease is open, so... (crosses fingers)  
Chandler: Good luck, man. I hope you get it.  
Joey: Thanks. 
``` 

## Реализация
Было реализовано 6 потоков: Chandler, Joey, Monica, Phoebe, Rachel и Ross. 
Каждый поток вызывает метод для вывода реплики, где захватывает блокировку и проверяет, 
является ли текущая реплика его собственной. Если это так, поток выводит реплику; если нет, он освобождает блокировку и засыпает на 10 миллисекунд.