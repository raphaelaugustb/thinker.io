## API Documentation

### User Functions

#### Create new account

```http
  POST /user/
```

| Parameter   | Type       | Description                           |
| :---------- | :--------- | :---------------------------------- |
| `username` | `String` | username |

| Parameter   | Type       | Description                           |
| :---------- | :--------- | :---------------------------------- |
| `password` | `String` | User passsword |

| Parameter   | Type       | Description                           |
| :---------- | :--------- | :---------------------------------- |
| `email` | `String` | User email |

#### Delete user by ID

```http
  DELETE /user/{id}
```

| Parameter   | Type       | Description                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `UUID` | User primary key |

#### Update user by ID

```http
  PUT /user/{id}
```

| Parameter   | Type       | Description                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `UUID` | User primary key |

#### Get user by ID

```http
  GET /user/{id}
```

| Parameter   | Type       | Description                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `UUID` |  User primary key |

### Idea Functions

#### Create idea passing one user

```http
  POST /user/{id}/idea
```

| Parameter   | Type       | Description                           |
| :---------- | :--------- | :---------------------------------- |
| `tittle` | `String` | Tittle of the idea |

| Parameter   | Type       | Description                           |
| :---------- | :--------- | :---------------------------------- |
| `Description` | `String` | Subscription of it  |

| Parameter   | Type       | Description                           |
| :---------- | :--------- | :---------------------------------- |
| `isFinished` | `boolean` | Determinate if it's done or not |

#### Delete idea passing one user

```http
  DELETE /user/{id}/idea/{idIdea}
```

| Parameter   | Type       | Description                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `UUID` | User primary key |

| Parameter   | Type       | Description                           |
| :---------- | :--------- | :---------------------------------- |
| `idIdea` | `Long` | Foreign key of idea |

#### Update idea passing one user
You don't have to update it all, you can pass one Parameter on the body if you want too

```http
  PUT /user/{id}/idea/{idIdea}
```

| Parameter   | Type       | Description                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `UUID` | User primary key |

| Parameter   | Type       | Description                           |
| :---------- | :--------- | :---------------------------------- |
| `idIdea` | `Long` | Foreign key of idea |

| Parameter   | Type       | Description                           |
| :---------- | :--------- | :---------------------------------- |
| `tittle` | `String` | new Tittle |

| Parameter   | Type       | Description                           |
| :---------- | :--------- | :---------------------------------- |
| `subscription` | `String` | new Subscription |

| Parameter   | Type       | Description                           |
| :---------- | :--------- | :---------------------------------- |
| `finished` | `boolean` | new State|  finished|not finished |

#### Get idea by tittle passing one user

```http
  GET /user/{id}/idea/{tittle}
```

| Parameter   | Type       | Description                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `UUID` |  User primary key |

| Parameter   | Type       | Description                           |
| :---------- | :--------- | :---------------------------------- |
| `idIdea` | `Long` | Foreign key of idea |

| Parameter   | Type       | Description                           |
| :---------- | :--------- | :---------------------------------- |
| `tittle` | `String` |Tittle |


## System Design
![image](![image](https://github.com/raphaelaugustb/thinker.io/assets/66183690/0b93a800-99ea-4523-a4a5-b38af0a4a1a8)



