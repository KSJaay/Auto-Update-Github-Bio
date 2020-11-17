# Auto-Update-Github-Bio
📚 GitHub biography auto updated using random quotes 

## 🚀Setup
### [Github] Token
Create a personal access token for github, this will be used to update your profile. [Click here](https://github.com/settings/tokens/new) and select the `User` field, once selected add a Note for the token and then click `Generate token`. Once you have done that copy the token and paste it into the variable called `apiKey`. 

### [Crontab] Running script every 24 hours
I personally wanted to run the script every 24 hours at midnight, but you can change that and run it at different times. To set this up we need to use crontab, [click here](https://opensource.com/article/17/11/how-use-cron-linux/) for a step by step tutorial of how you can set up crontab.
```
0 */12 * * * /path/to/Auto-Update-Github-Bio/Github.kt
```

### What's next?
That's it you're done, the script will now run every 24 hours 

## 📝 Credits

[Type.fit](https://type.fit) for providing the quotes used, which can be found at https://type.fit/api/quotes
