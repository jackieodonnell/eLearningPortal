<template>
  <div class="card">
    <router-link
      :to="{ name: 'course-page', params: { courseId: course.courseId } }"
    >
      <div class="card-img"></div>
      <div class="card-info">
        <div class="card-text">
          <h2 class="course-title">{{ course.courseTitle }}</h2>
          <h4 class="course-difficulty">Level {{ course.difficulty }}</h4>
        </div>
        <div class="card-icon">
          <svg viewBox="0 0 28 25">
            <path
              d="M13.145 2.13l1.94-1.867 12.178 12-12.178 12-1.94-1.867 8.931-8.8H.737V10.93h21.339z"
            ></path>
          </svg>
        </div>
      </div>
    </router-link>
  </div>
</template>

<script>
export default {
  name: "course-card",
  props: ["course"],
  methods: {},
};
</script>

<style>
.card {
  margin: 30px;
  width: 190px;
  height: 254px;
  position: relative;
  background: #f5f5f5;
  transition: box-shadow 0.3s cubic-bezier(0.175, 0.885, 0.32, 1.275);
  box-shadow: 5px 5px;
  border-radius: 20px;
}

.card-img {
  position: absolute;
  height: 100%;
  width: 100%;
  background-color: #ffe25ff3;
  border-radius: 20px;
}

.card-info {
  position: absolute;
  width: 100%;
  bottom: 0;
  padding: 1rem;
  display: flex;
  align-items: flex-end;
  justify-content: space-between;
}

.card-icon {
  opacity: 0;
  transform: translateX(-20%);
  width: 2em;
  height: 2em;
  transition: all 0.3s ease-in-out;
}

svg {
  --size: 20px;
  width: var(--size);
  height: var(--size);
}

p {
  line-height: 140%;
}

.text-title {
  font-weight: 900;
  font-size: 18px;
}

.text-subtitle {
  color: #333;
  font-weight: 500;
  font-size: 16px;
}

.card-text {
  color: #001a33d3;
}

.card:hover {
  box-shadow: 0 10px 20px 4px rgba(35, 35, 35, 0.1);
}

.card:hover .card-icon {
  opacity: 1;
  transform: translateX(20%);
}
</style>