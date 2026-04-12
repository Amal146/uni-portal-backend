/**
 * Normalized CourseLecturer junction table data.
 * 
 * Entity: CourseLecturer (many-to-many relationship)
 * ─────────────────────────────────────────────────────────────────────────────
 * id          — unique identifier
 * courseId    — FK → Course
 * lecturerId  — FK → Lecturer
 * role        — 'primary' | 'secondary' | 'coordinator'
 */

export const COURSE_LECTURERS = [
  // Digital Innovation
  { id: 'cl-001', courseId: 'crs-001', lecturerId: 'lec-01', role: 'primary' },
  { id: 'cl-002', courseId: 'crs-001', lecturerId: 'lec-02', role: 'secondary' },
  
  // Business Process Management
  { id: 'cl-003', courseId: 'crs-002', lecturerId: 'lec-03', role: 'primary' },
  { id: 'cl-004', courseId: 'crs-002', lecturerId: 'lec-04', role: 'secondary' },
  
  // Management Information Systems
  { id: 'cl-005', courseId: 'crs-003', lecturerId: 'lec-05', role: 'primary' },
  
  // Information Systems Development
  { id: 'cl-006', courseId: 'crs-004', lecturerId: 'lec-06', role: 'primary' },
  { id: 'cl-007', courseId: 'crs-004', lecturerId: 'lec-07', role: 'secondary' },
  
  // Data Management
  { id: 'cl-008', courseId: 'crs-005', lecturerId: 'lec-08', role: 'primary' },
  
  // Business Statistics
  { id: 'cl-009', courseId: 'crs-006', lecturerId: 'lec-09', role: 'primary' },
  { id: 'cl-010', courseId: 'crs-006', lecturerId: 'lec-10', role: 'secondary' },
  
  // Web-based Information Systems
  { id: 'cl-011', courseId: 'crs-007', lecturerId: 'lec-11', role: 'primary' },
  { id: 'cl-012', courseId: 'crs-007', lecturerId: 'lec-12', role: 'secondary' },
  
  // Data and Application Security
  { id: 'cl-013', courseId: 'crs-008', lecturerId: 'lec-13', role: 'primary' },
  { id: 'cl-014', courseId: 'crs-008', lecturerId: 'lec-14', role: 'secondary' },
  
  // Data Science and AI
  { id: 'cl-015', courseId: 'crs-009', lecturerId: 'lec-07', role: 'primary' },
  { id: 'cl-016', courseId: 'crs-009', lecturerId: 'lec-19', role: 'secondary' },
  
  // Information Systems Modelling
  { id: 'cl-017', courseId: 'crs-010', lecturerId: 'lec-04', role: 'primary' },
  
  // IT Law, Ethics and Governance
  { id: 'cl-018', courseId: 'crs-011', lecturerId: 'lec-15', role: 'primary' },
  { id: 'cl-019', courseId: 'crs-011', lecturerId: 'lec-16', role: 'secondary' },
  
  // Emerging IT Topics
  { id: 'cl-020', courseId: 'crs-012', lecturerId: 'lec-13', role: 'primary' },
  { id: 'cl-021', courseId: 'crs-012', lecturerId: 'lec-06', role: 'coordinator' },
  { id: 'cl-022', courseId: 'crs-012', lecturerId: 'lec-11', role: 'secondary' },
  { id: 'cl-023', courseId: 'crs-012', lecturerId: 'lec-07', role: 'secondary' },
  { id: 'cl-024', courseId: 'crs-012', lecturerId: 'lec-17', role: 'secondary' },
  { id: 'cl-025', courseId: 'crs-012', lecturerId: 'lec-12', role: 'secondary' },
  
  // Innovation Lab
  { id: 'cl-026', courseId: 'crs-013', lecturerId: 'lec-17', role: 'primary' },
  { id: 'cl-027', courseId: 'crs-013', lecturerId: 'lec-02', role: 'secondary' },
  
  // Research Methods
  { id: 'cl-028', courseId: 'crs-014', lecturerId: 'lec-05', role: 'primary' },
  { id: 'cl-029', courseId: 'crs-014', lecturerId: 'lec-18', role: 'secondary' },
  
  // Research Seminar
  { id: 'cl-030', courseId: 'crs-015', lecturerId: 'lec-01', role: 'primary' },
  
  // Project Seminar
  { id: 'cl-031', courseId: 'crs-016', lecturerId: 'lec-03', role: 'primary' },
  { id: 'cl-032', courseId: 'crs-016', lecturerId: 'lec-07', role: 'secondary' },
  
  // Core Electives
  { id: 'cl-100', courseId: 'ce-bpm-1', lecturerId: 'lec-03', role: 'primary' },
  { id: 'cl-101', courseId: 'ce-bpm-2', lecturerId: 'lec-04', role: 'primary' },
  { id: 'cl-102', courseId: 'ce-bpm-3', lecturerId: 'lec-03', role: 'primary' },
  { id: 'cl-103', courseId: 'ce-sec-1', lecturerId: 'lec-13', role: 'primary' },
  { id: 'cl-104', courseId: 'ce-sec-2', lecturerId: 'lec-13', role: 'primary' },
  { id: 'cl-105', courseId: 'ce-sec-3', lecturerId: 'lec-14', role: 'primary' },
  { id: 'cl-106', courseId: 'ce-ai-1', lecturerId: 'lec-07', role: 'primary' },
  { id: 'cl-107', courseId: 'ce-ai-2', lecturerId: 'lec-19', role: 'primary' },
  { id: 'cl-108', courseId: 'ce-ai-3', lecturerId: 'lec-19', role: 'primary' },
  { id: 'cl-109', courseId: 'ce-ai-4', lecturerId: 'lec-07', role: 'primary' },
  { id: 'cl-110', courseId: 'ce-ai-5', lecturerId: 'lec-19', role: 'primary' },
  { id: 'cl-111', courseId: 'ce-di-1', lecturerId: 'lec-01', role: 'primary' },
  { id: 'cl-112', courseId: 'ce-di-2', lecturerId: 'lec-01', role: 'primary' },
  { id: 'cl-113', courseId: 'ce-di-3', lecturerId: 'lec-02', role: 'primary' },
  { id: 'cl-114', courseId: 'ce-oth-1', lecturerId: 'lec-17', role: 'primary' },
  { id: 'cl-115', courseId: 'ce-oth-2', lecturerId: 'lec-06', role: 'primary' },
  
  // Cross-Faculty
  { id: 'cl-200', courseId: 'cf-eng-1', lecturerId: 'lec-22', role: 'coordinator' },
  { id: 'cl-201', courseId: 'cf-eng-1', lecturerId: 'lec-23', role: 'primary' },
  { id: 'cl-202', courseId: 'cf-eng-2', lecturerId: 'lec-22', role: 'coordinator' },
  { id: 'cl-203', courseId: 'cf-eng-2', lecturerId: 'lec-23', role: 'primary' },
  { id: 'cl-204', courseId: 'cf-radio-1', lecturerId: 'lec-24', role: 'coordinator' },
  { id: 'cl-205', courseId: 'cf-radio-1', lecturerId: 'lec-25', role: 'primary' },
  { id: 'cl-206', courseId: 'cf-coaching-1', lecturerId: 'lec-24', role: 'coordinator' },
  { id: 'cl-207', courseId: 'cf-coaching-1', lecturerId: 'lec-26', role: 'primary' },
  { id: 'cl-208', courseId: 'cf-creative-1', lecturerId: 'lec-27', role: 'primary' },
  { id: 'cl-209', courseId: 'cf-ger-1', lecturerId: 'lec-22', role: 'primary' },
  { id: 'cl-210', courseId: 'cf-pro-1', lecturerId: 'lec-27', role: 'primary' },
  { id: 'cl-211', courseId: 'cf-pres-1', lecturerId: 'lec-24', role: 'primary' },
  
  // WS 26/27 courses
  { id: 'cl-300', courseId: 'ws27-m1', lecturerId: 'lec-20', role: 'primary' },
  { id: 'cl-301', courseId: 'ws27-m2', lecturerId: 'lec-13', role: 'primary' },
  { id: 'cl-302', courseId: 'ws27-m3', lecturerId: 'lec-21', role: 'primary' },
  { id: 'cl-303', courseId: 'ws27-m4', lecturerId: 'lec-04', role: 'primary' },
]; // /**
 * Normalized CourseLecturer junction table data.
 * 
 * Entity: CourseLecturer (many-to-many relationship)
 * ─────────────────────────────────────────────────────────────────────────────
 * id          — unique identifier
 * courseId    — FK → Course
 * lecturerId  — FK → Lecturer
 * role        — 'primary' | 'secondary' | 'coordinator'
 */

export const COURSE_LECTURERS = [
  // Digital Innovation
  { id: 'cl-001', courseId: 'crs-001', lecturerId: 'lec-01', role: 'primary' },
  { id: 'cl-002', courseId: 'crs-001', lecturerId: 'lec-02', role: 'secondary' },
  
  // Business Process Management
  { id: 'cl-003', courseId: 'crs-002', lecturerId: 'lec-03', role: 'primary' },
  { id: 'cl-004', courseId: 'crs-002', lecturerId: 'lec-04', role: 'secondary' },
  
  // Management Information Systems
  { id: 'cl-005', courseId: 'crs-003', lecturerId: 'lec-05', role: 'primary' },
  
  // Information Systems Development
  { id: 'cl-006', courseId: 'crs-004', lecturerId: 'lec-06', role: 'primary' },
  { id: 'cl-007', courseId: 'crs-004', lecturerId: 'lec-07', role: 'secondary' },
  
  // Data Management
  { id: 'cl-008', courseId: 'crs-005', lecturerId: 'lec-08', role: 'primary' },
  
  // Business Statistics
  { id: 'cl-009', courseId: 'crs-006', lecturerId: 'lec-09', role: 'primary' },
  { id: 'cl-010', courseId: 'crs-006', lecturerId: 'lec-10', role: 'secondary' },
  
  // Web-based Information Systems
  { id: 'cl-011', courseId: 'crs-007', lecturerId: 'lec-11', role: 'primary' },
  { id: 'cl-012', courseId: 'crs-007', lecturerId: 'lec-12', role: 'secondary' },
  
  // Data and Application Security
  { id: 'cl-013', courseId: 'crs-008', lecturerId: 'lec-13', role: 'primary' },
  { id: 'cl-014', courseId: 'crs-008', lecturerId: 'lec-14', role: 'secondary' },
  
  // Data Science and AI
  { id: 'cl-015', courseId: 'crs-009', lecturerId: 'lec-07', role: 'primary' },
  { id: 'cl-016', courseId: 'crs-009', lecturerId: 'lec-19', role: 'secondary' },
  
  // Information Systems Modelling
  { id: 'cl-017', courseId: 'crs-010', lecturerId: 'lec-04', role: 'primary' },
  
  // IT Law, Ethics and Governance
  { id: 'cl-018', courseId: 'crs-011', lecturerId: 'lec-15', role: 'primary' },
  { id: 'cl-019', courseId: 'crs-011', lecturerId: 'lec-16', role: 'secondary' },
  
  // Emerging IT Topics
  { id: 'cl-020', courseId: 'crs-012', lecturerId: 'lec-13', role: 'primary' },
  { id: 'cl-021', courseId: 'crs-012', lecturerId: 'lec-06', role: 'coordinator' },
  { id: 'cl-022', courseId: 'crs-012', lecturerId: 'lec-11', role: 'secondary' },
  { id: 'cl-023', courseId: 'crs-012', lecturerId: 'lec-07', role: 'secondary' },
  { id: 'cl-024', courseId: 'crs-012', lecturerId: 'lec-17', role: 'secondary' },
  { id: 'cl-025', courseId: 'crs-012', lecturerId: 'lec-12', role: 'secondary' },
  
  // Innovation Lab
  { id: 'cl-026', courseId: 'crs-013', lecturerId: 'lec-17', role: 'primary' },
  { id: 'cl-027', courseId: 'crs-013', lecturerId: 'lec-02', role: 'secondary' },
  
  // Research Methods
  { id: 'cl-028', courseId: 'crs-014', lecturerId: 'lec-05', role: 'primary' },
  { id: 'cl-029', courseId: 'crs-014', lecturerId: 'lec-18', role: 'secondary' },
  
  // Research Seminar
  { id: 'cl-030', courseId: 'crs-015', lecturerId: 'lec-01', role: 'primary' },
  
  // Project Seminar
  { id: 'cl-031', courseId: 'crs-016', lecturerId: 'lec-03', role: 'primary' },
  { id: 'cl-032', courseId: 'crs-016', lecturerId: 'lec-07', role: 'secondary' },
  
  // Core Electives
  { id: 'cl-100', courseId: 'ce-bpm-1', lecturerId: 'lec-03', role: 'primary' },
  { id: 'cl-101', courseId: 'ce-bpm-2', lecturerId: 'lec-04', role: 'primary' },
  { id: 'cl-102', courseId: 'ce-bpm-3', lecturerId: 'lec-03', role: 'primary' },
  { id: 'cl-103', courseId: 'ce-sec-1', lecturerId: 'lec-13', role: 'primary' },
  { id: 'cl-104', courseId: 'ce-sec-2', lecturerId: 'lec-13', role: 'primary' },
  { id: 'cl-105', courseId: 'ce-sec-3', lecturerId: 'lec-14', role: 'primary' },
  { id: 'cl-106', courseId: 'ce-ai-1', lecturerId: 'lec-07', role: 'primary' },
  { id: 'cl-107', courseId: 'ce-ai-2', lecturerId: 'lec-19', role: 'primary' },
  { id: 'cl-108', courseId: 'ce-ai-3', lecturerId: 'lec-19', role: 'primary' },
  { id: 'cl-109', courseId: 'ce-ai-4', lecturerId: 'lec-07', role: 'primary' },
  { id: 'cl-110', courseId: 'ce-ai-5', lecturerId: 'lec-19', role: 'primary' },
  { id: 'cl-111', courseId: 'ce-di-1', lecturerId: 'lec-01', role: 'primary' },
  { id: 'cl-112', courseId: 'ce-di-2', lecturerId: 'lec-01', role: 'primary' },
  { id: 'cl-113', courseId: 'ce-di-3', lecturerId: 'lec-02', role: 'primary' },
  { id: 'cl-114', courseId: 'ce-oth-1', lecturerId: 'lec-17', role: 'primary' },
  { id: 'cl-115', courseId: 'ce-oth-2', lecturerId: 'lec-06', role: 'primary' },
  
  // Cross-Faculty
  { id: 'cl-200', courseId: 'cf-eng-1', lecturerId: 'lec-22', role: 'coordinator' },
  { id: 'cl-201', courseId: 'cf-eng-1', lecturerId: 'lec-23', role: 'primary' },
  { id: 'cl-202', courseId: 'cf-eng-2', lecturerId: 'lec-22', role: 'coordinator' },
  { id: 'cl-203', courseId: 'cf-eng-2', lecturerId: 'lec-23', role: 'primary' },
  { id: 'cl-204', courseId: 'cf-radio-1', lecturerId: 'lec-24', role: 'coordinator' },
  { id: 'cl-205', courseId: 'cf-radio-1', lecturerId: 'lec-25', role: 'primary' },
  { id: 'cl-206', courseId: 'cf-coaching-1', lecturerId: 'lec-24', role: 'coordinator' },
  { id: 'cl-207', courseId: 'cf-coaching-1', lecturerId: 'lec-26', role: 'primary' },
  { id: 'cl-208', courseId: 'cf-creative-1', lecturerId: 'lec-27', role: 'primary' },
  { id: 'cl-209', courseId: 'cf-ger-1', lecturerId: 'lec-22', role: 'primary' },
  { id: 'cl-210', courseId: 'cf-pro-1', lecturerId: 'lec-27', role: 'primary' },
  { id: 'cl-211', courseId: 'cf-pres-1', lecturerId: 'lec-24', role: 'primary' },
  
  // WS 26/27 courses
  { id: 'cl-300', courseId: 'ws27-m1', lecturerId: 'lec-20', role: 'primary' },
  { id: 'cl-301', courseId: 'ws27-m2', lecturerId: 'lec-13', role: 'primary' },
  { id: 'cl-302', courseId: 'ws27-m3', lecturerId: 'lec-21', role: 'primary' },
  { id: 'cl-303', courseId: 'ws27-m4', lecturerId: 'lec-04', role: 'primary' },
]; // /**
 * Normalized ElectiveRule entity data.
 *
 * Table: elective_rules
 * ─────────────────────────────────────────────────────────────────────────────
 * id                  — PK
 * programmeId         — FK → programmes.id
 * type                — 'core_elective' | 'cross_faculty'
 * totalSlots          — number of slots required
 * ectsPerSlot         — ECTS per slot
 * requiredEcts        — total ECTS required for this type
 * maxSubstituteEcts   — combined cap on ECTS that may come from substitute courses
 *                       NULL means substitution is not allowed for this rule
 *
 * Table: elective_substitution_rules
 * ─────────────────────────────────────────────────────────────────────────────
 * id              — PK
 * electiveRuleId  — FK → elective_rules.id  (the requirement being substituted)
 * programmeId     — FK → programmes.id
 * substituteType  — 'cross_programme' | 'core_elective'  (what may stand in)
 * maxEcts         — max ECTS of this substitute type that may fulfill the target
 * maxCourses      — max number of courses of this substitute type (NULL = no limit)
 */

export const ELECTIVE_RULES = [
  {
    id: 'er-mis-ce',
    programmeId: 'prog-mis',
    type: 'core_elective',
    totalSlots: 6,
    ectsPerSlot: 3,
    requiredEcts: 18,
    maxSubstituteEcts: null,
  },
  {
    id: 'er-mis-cf',
    programmeId: 'prog-mis',
    type: 'cross_faculty',
    totalSlots: 4,
    ectsPerSlot: 3,
    requiredEcts: 12,
    maxSubstituteEcts: 9,   // at most 9 of 12 ECTS may come from substitute courses
  },
];

export const ELECTIVE_SUBSTITUTION_RULES = [
  {
    id: 'esr-mis-cf-cp',
    electiveRuleId: 'er-mis-cf',
    programmeId: 'prog-mis',
    substituteType: 'cross_programme',
    maxEcts: 6,
    maxCourses: 2,
  },
  {
    id: 'esr-mis-cf-ce',
    electiveRuleId: 'er-mis-cf',
    programmeId: 'prog-mis',
    substituteType: 'core_elective',
    maxEcts: 3,
    maxCourses: 1,
  },
];///**
 * Normalized ElectiveRule entity data.
 *
 * Table: elective_rules
 * ─────────────────────────────────────────────────────────────────────────────
 * id                  — PK
 * programmeId         — FK → programmes.id
 * type                — 'core_elective' | 'cross_faculty'
 * totalSlots          — number of slots required
 * ectsPerSlot         — ECTS per slot
 * requiredEcts        — total ECTS required for this type
 * maxSubstituteEcts   — combined cap on ECTS that may come from substitute courses
 *                       NULL means substitution is not allowed for this rule
 *
 * Table: elective_substitution_rules
 * ─────────────────────────────────────────────────────────────────────────────
 * id              — PK
 * electiveRuleId  — FK → elective_rules.id  (the requirement being substituted)
 * programmeId     — FK → programmes.id
 * substituteType  — 'cross_programme' | 'core_elective'  (what may stand in)
 * maxEcts         — max ECTS of this substitute type that may fulfill the target
 * maxCourses      — max number of courses of this substitute type (NULL = no limit)
 */

export const ELECTIVE_RULES = [
  {
    id: 'er-mis-ce',
    programmeId: 'prog-mis',
    type: 'core_elective',
    totalSlots: 6,
    ectsPerSlot: 3,
    requiredEcts: 18,
    maxSubstituteEcts: null,
  },
  {
    id: 'er-mis-cf',
    programmeId: 'prog-mis',
    type: 'cross_faculty',
    totalSlots: 4,
    ectsPerSlot: 3,
    requiredEcts: 12,
    maxSubstituteEcts: 9,   // at most 9 of 12 ECTS may come from substitute courses
  },
];

export const ELECTIVE_SUBSTITUTION_RULES = [
  {
    id: 'esr-mis-cf-cp',
    electiveRuleId: 'er-mis-cf',
    programmeId: 'prog-mis',
    substituteType: 'cross_programme',
    maxEcts: 6,
    maxCourses: 2,
  },
  {
    id: 'esr-mis-cf-ce',
    electiveRuleId: 'er-mis-cf',
    programmeId: 'prog-mis',
    substituteType: 'core_elective',
    maxEcts: 3,
    maxCourses: 1,
  },
]; // /**
 * Normalized ElectiveRule entity data.
 *
 * Table: elective_rules
 * ─────────────────────────────────────────────────────────────────────────────
 * id                  — PK
 * programmeId         — FK → programmes.id
 * type                — 'core_elective' | 'cross_faculty'
 * totalSlots          — number of slots required
 * ectsPerSlot         — ECTS per slot
 * requiredEcts        — total ECTS required for this type
 * maxSubstituteEcts   — combined cap on ECTS that may come from substitute courses
 *                       NULL means substitution is not allowed for this rule
 *
 * Table: elective_substitution_rules
 * ─────────────────────────────────────────────────────────────────────────────
 * id              — PK
 * electiveRuleId  — FK → elective_rules.id  (the requirement being substituted)
 * programmeId     — FK → programmes.id
 * substituteType  — 'cross_programme' | 'core_elective'  (what may stand in)
 * maxEcts         — max ECTS of this substitute type that may fulfill the target
 * maxCourses      — max number of courses of this substitute type (NULL = no limit)
 */

export const ELECTIVE_RULES = [
  {
    id: 'er-mis-ce',
    programmeId: 'prog-mis',
    type: 'core_elective',
    totalSlots: 6,
    ectsPerSlot: 3,
    requiredEcts: 18,
    maxSubstituteEcts: null,
  },
  {
    id: 'er-mis-cf',
    programmeId: 'prog-mis',
    type: 'cross_faculty',
    totalSlots: 4,
    ectsPerSlot: 3,
    requiredEcts: 12,
    maxSubstituteEcts: 9,   // at most 9 of 12 ECTS may come from substitute courses
  },
];

export const ELECTIVE_SUBSTITUTION_RULES = [
  {
    id: 'esr-mis-cf-cp',
    electiveRuleId: 'er-mis-cf',
    programmeId: 'prog-mis',
    substituteType: 'cross_programme',
    maxEcts: 6,
    maxCourses: 2,
  },
  {
    id: 'esr-mis-cf-ce',
    electiveRuleId: 'er-mis-cf',
    programmeId: 'prog-mis',
    substituteType: 'core_elective',
    maxEcts: 3,
    maxCourses: 1,
  },
]; //  /**
 * Normalized ExamRegistration entity data.
 * 
 * Entity: ExamRegistration
 * ─────────────────────────────────────────────────────────────────────────────
 * id              — unique registration identifier
 * studentId       — FK → Student
 * examId          — FK → Exam
 * status          — 'registered' | 'completed' | 'failed' | 'cancelled' | 'no-show'
 * registeredAt    — registration timestamp
 * grade           — final grade (if completed)
 * attempt         — attempt number (1, 2, 3...)
 */

export const EXAM_REGISTRATIONS = [
  // ─── SS 2026/27 Exam Registrations ──────────────────────────────────────────
  // IT Law, Ethics and Governance - exam already completed (2026-02-19)
  {
    id: 'exreg-001',
    studentId: 'stu-001',
    examId: 'exam-008', // IT Law, Ethics and Governance (crs-011)
    status: 'completed',
    registeredAt: '2026-02-01T00:00:00Z',
    grade: 1.7,
    attempt: 1,
  },
  // Data and Application Security - registered for June exam
  {
    id: 'exreg-002',
    studentId: 'stu-001',
    examId: 'exam-005', // Data and Application Security (crs-008)
    status: 'registered',
    registeredAt: '2026-03-08T00:00:00Z',
    grade: null,
    attempt: 1,
  },
  // Web-based Information Systems - registered for June exam
  {
    id: 'exreg-003',
    studentId: 'stu-001',
    examId: 'exam-007', // Web-based Information Systems (crs-007)
    status: 'registered',
    registeredAt: '2026-03-08T00:00:00Z',
    grade: null,
    attempt: 1,
  },

  // ─── WS 2025/26 Exam Registrations ─────────────────────────────────────────
  // Data Management - failed (grade 5.0)
  {
    id: 'exreg-004',
    studentId: 'stu-001',
    examId: 'exam-009', // Data Management (crs-005)
    status: 'failed',
    registeredAt: '2025-12-01T00:00:00Z',
    grade: 5.0,
    attempt: 1,
  },
  // Digital Innovation - completed (grade 1.5)
  {
    id: 'exreg-005',
    studentId: 'stu-001',
    examId: 'exam-010', // Digital Innovation (crs-001)
    status: 'completed',
    registeredAt: '2025-12-01T00:00:00Z',
    grade: 1.5,
    attempt: 1,
  },
  // Business Process Management - completed (grade 2.0)
  {
    id: 'exreg-006',
    studentId: 'stu-001',
    examId: 'exam-011', // Business Process Management (crs-002)
    status: 'completed',
    registeredAt: '2025-12-01T00:00:00Z',
    grade: 2.0,
    attempt: 1,
  },
  // Business Statistics - completed (grade 1.8)
  {
    id: 'exreg-007',
    studentId: 'stu-001',
    examId: 'exam-012', // Business Statistics (crs-006)
    status: 'completed',
    registeredAt: '2025-12-01T00:00:00Z',
    grade: 1.8,
    attempt: 1,
  },
]; // /**
 * Normalized Exam entity data.
 * 
 * Entity: Exam
 * ─────────────────────────────────────────────────────────────────────────────
 * id          — unique exam identifier
 * courseId    — FK → Course
 * moduleId    — FK → Module (parent entity)
 * semesterId  — FK → Semester
 * type        — 'written' | 'oral' | 'project' | 'presentation'
 * date        — exam date (YYYY-MM-DD)
 * time        — time range
 * duration    — duration in minutes
 * room        — location
 */

export const EXAMS = [
  // ─── WS 2025/26 Exams ───────────────────────────────────────────────────────
  // ─── SS 2026/27 Exams (Current) ─────────────────────────────────────────────
  {
    id: 'exam-005',
    courseId: 'crs-008',    // Data and Application Security
    moduleId: 'mod-07',
    semesterId: 'sem-ss2026',
    type: 'written',
    date: '2026-06-11',
    time: '08:30–11:45',
    duration: 180,
    room: 'Exam Hall B',
  },
  {
    id: 'exam-006',
    courseId: 'crs-009',    // Data Science and Artificial Intelligence
    moduleId: 'mod-dsai',
    semesterId: 'sem-ss2026',
    type: 'written',
    date: '2026-06-12',
    time: '08:30–11:30',
    duration: 180,
    room: 'Exam Hall C',
  },
  {
    id: 'exam-007',
    courseId: 'crs-007',    // Web-based Information Systems
    moduleId: 'mod-06',
    semesterId: 'sem-ss2026',
    type: 'written',
    date: '2026-06-18',
    time: '12:30–15:45',
    duration: 180,
    room: 'Exam Hall A',
  },
  {
    id: 'exam-008',
    courseId: 'crs-011',    // IT Law, Ethics and Governance
    moduleId: 'mod-itleg',
    semesterId: 'sem-ss2026',
    type: 'written',
    date: '2026-02-19',
    time: '09:00–11:00',
    duration: 120,
    room: 'Exam Hall A',
  },
  {
    id: 'exam-013',
    courseId: 'crs-010',    // Information Systems Modelling
    moduleId: 'mod-ismod',
    semesterId: 'sem-ss2026',
    type: 'written',
    date: '2026-06-15',
    time: '12:30–14:30',
    duration: 120,
    room: 'Exam Hall A',
  },
  {
    id: 'exam-014',
    courseId: 'crs-012',    // Emerging IT Topics
    moduleId: 'mod-08',
    semesterId: 'sem-ss2026',
    type: 'presentation',
    date: '2026-06-23',
    time: '09:00–12:00',
    duration: 180,
    room: 'Seminar Room 2',
  },
  {
    id: 'exam-015',
    courseId: 'crs-013',    // Innovation Lab
    moduleId: 'mod-ilab',
    semesterId: 'sem-ss2026',
    type: 'project',
    date: '2026-06-24',
    time: '09:00–12:00',
    duration: 180,
    room: 'Innovation Lab',
  },
  {
    id: 'exam-009',
    courseId: 'crs-005',    // Data Management
    moduleId: 'mod-04',
    semesterId: 'sem-ws2025',
    type: 'written',
    date: '2026-01-20',
    time: '09:00–12:00',
    duration: 180,
    room: 'Exam Hall B',

  },
  {
    id: 'exam-010',
    courseId: 'crs-001',    // Digital Innovation
    moduleId: 'mod-01',
    semesterId: 'sem-ws2025',
    type: 'written',
    date: '2026-01-14',
    time: '09:00–12:00',
    duration: 180,
    room: 'Exam Hall A',

  },
  {
    id: 'exam-011',
    courseId: 'crs-002',    // Business Process Management
    moduleId: 'mod-02',
    semesterId: 'sem-ws2025',
    type: 'written',
    date: '2026-01-16',
    time: '09:00–12:00',
    duration: 180,
    room: 'Exam Hall B',

  },
  {
    id: 'exam-012',
    courseId: 'crs-006',    // Business Statistics
    moduleId: 'mod-05',
    semesterId: 'sem-ws2025',
    type: 'written',
    date: '2026-01-19',
    time: '13:00–15:00',
    duration: 120,
    room: 'Exam Hall C',
  },
]; // /**
 * Normalized Holiday entity data.
 * 
 * Entity: Holiday
 * ─────────────────────────────────────────────────────────────────────────────
 * id          — unique holiday identifier
 * type        — always 'holiday'
 * title       — holiday name
 * date        — holiday date (YYYY-MM-DD)
 * description — additional details
 * semesterId  — FK → SemesterMeta (for filtering)
 * 
 * Note: Holidays are NOT derived from other entities. They are static reference
 * data used by the calendar to display non-working days.
 */

// ─── WS 2025/26 Holidays (Liechtenstein) ──────────────────────────────────────
export const WS2025_HOLIDAYS = [
  { id: 'h01', type: 'holiday', title: 'Nativity of Our Lady', date: '2025-09-08', time: null, room: null, courseId: null, examId: null, description: 'Maria Geburt — National Holiday', semesterId: 'sem-ws2025' },
  { id: 'h02', type: 'holiday', title: "All Saints' Day", date: '2025-11-01', time: null, room: null, courseId: null, examId: null, description: 'Allerheiligen — National Holiday', semesterId: 'sem-ws2025' },
  { id: 'h03', type: 'holiday', title: 'Immaculate Conception', date: '2025-12-08', time: null, room: null, courseId: null, examId: null, description: 'Maria Empfängnis — National Holiday', semesterId: 'sem-ws2025' },
  { id: 'h04', type: 'holiday', title: 'Christmas Eve', date: '2025-12-24', time: null, room: null, courseId: null, examId: null, description: 'Heiligabend — Bank Holiday', semesterId: 'sem-ws2025' },
  { id: 'h05', type: 'holiday', title: 'Christmas Day', date: '2025-12-25', time: null, room: null, courseId: null, examId: null, description: 'Weihnachten — National Holiday', semesterId: 'sem-ws2025' },
  { id: 'h06', type: 'holiday', title: "St. Stephen's Day", date: '2025-12-26', time: null, room: null, courseId: null, examId: null, description: 'Stephanstag — National Holiday', semesterId: 'sem-ws2025' },
  { id: 'h07', type: 'holiday', title: "New Year's Eve", date: '2025-12-31', time: null, room: null, courseId: null, examId: null, description: 'Silvester — Bank Holiday', semesterId: 'sem-ws2025' },
  { id: 'h08', type: 'holiday', title: "New Year's Day", date: '2026-01-01', time: null, room: null, courseId: null, examId: null, description: 'Neujahr — National Holiday', semesterId: 'sem-ws2025' },
  { id: 'h09', type: 'holiday', title: 'Berchtold Day', date: '2026-01-02', time: null, room: null, courseId: null, examId: null, description: 'Berchtoldstag — Bank Holiday', semesterId: 'sem-ws2025' },
  { id: 'h10', type: 'holiday', title: 'Epiphany', date: '2026-01-06', time: null, room: null, courseId: null, examId: null, description: 'Heilige Drei Könige — National Holiday', semesterId: 'sem-ws2025' },
];

// ─── SS 2026/27 Holidays (Liechtenstein) ──────────────────────────────────────
export const SS2026_HOLIDAYS = [
  { id: 'h11', type: 'holiday', title: 'Candlemas', date: '2026-02-02', time: null, room: null, courseId: null, examId: null, description: 'Maria Lichtmess — National Holiday', semesterId: 'sem-ss2026' },
  { id: 'h12', type: 'holiday', title: 'Shrove Tuesday', date: '2026-02-17', time: null, room: null, courseId: null, examId: null, description: 'Fasnachtsdienstag — Bank Holiday', semesterId: 'sem-ss2026' },
  { id: 'h13', type: 'holiday', title: "St. Joseph's Day", date: '2026-03-19', time: null, room: null, courseId: null, examId: null, description: 'Josefstag — National Holiday', semesterId: 'sem-ss2026' },
  { id: 'h14', type: 'holiday', title: 'Good Friday', date: '2026-04-03', time: null, room: null, courseId: null, examId: null, description: 'Karfreitag — Bank Holiday', semesterId: 'sem-ss2026' },
  { id: 'h15', type: 'holiday', title: 'Easter Monday', date: '2026-04-06', time: null, room: null, courseId: null, examId: null, description: 'Ostermontag — National Holiday', semesterId: 'sem-ss2026' },
  { id: 'h16', type: 'holiday', title: 'Labour Day', date: '2026-05-01', time: null, room: null, courseId: null, examId: null, description: 'Tag der Arbeit — National Holiday', semesterId: 'sem-ss2026' },
  { id: 'h17', type: 'holiday', title: 'Ascension Day', date: '2026-05-14', time: null, room: null, courseId: null, examId: null, description: 'Christi Himmelfahrt — National Holiday', semesterId: 'sem-ss2026' },
  { id: 'h18', type: 'holiday', title: 'Ascension Day Holiday', date: '2026-05-15', time: null, room: null, courseId: null, examId: null, description: 'Tag nach Auffahrt — National Holiday', semesterId: 'sem-ss2026' },
  { id: 'h19', type: 'holiday', title: 'Whit Monday', date: '2026-05-25', time: null, room: null, courseId: null, examId: null, description: 'Pfingstmontag — National Holiday', semesterId: 'sem-ss2026' },
  { id: 'h20', type: 'holiday', title: 'Corpus Christi', date: '2026-06-04', time: null, room: null, courseId: null, examId: null, description: 'Fronleichnam — National Holiday', semesterId: 'sem-ss2026' },
  { id: 'h21', type: 'holiday', title: 'Corpus Christi Holiday', date: '2026-06-05', time: null, room: null, courseId: null, examId: null, description: 'Tag nach Fronleichnam — National Holiday', semesterId: 'sem-ss2026' },
];

// ─── All Holidays Combined ────────────────────────────────────────────────────
export const HOLIDAYS = [
  ...WS2025_HOLIDAYS,
  ...SS2026_HOLIDAYS,
]; ///**
 * Normalized Entity Data Index
 * 
 * Single export point for all normalized entity data.
 * Import from here to access clean, normalized mock data.
 * 
 * Note: CalendarEvent is no longer a stored entity. Calendar events are
 * DERIVED at runtime from: Enrollment + Schedule + Exam + Holiday.
 * See calendarSelectors.js for the derivation logic.
 */

import { STUDENTS as _STUDENTS, CURRENT_STUDENT_ID } from './students';
import { SEMESTERS as _SEMESTERS, CURRENT_SEMESTER_ID, generateSemesterSlots } from './semesters';

// ─── Core Entities ────────────────────────────────────────────────────────────
export { STUDENTS, CURRENT_STUDENT_ID } from './students';
export { PROGRAMMES, DEFAULT_PROGRAMME_ID } from './programmes';
export { SEMESTERS, CURRENT_SEMESTER_ID, generateSemesterSlots } from './semesters';
export { LECTURERS, LECTURER_NAME_MAP } from './lecturers';
export { MODULES, MODULE_NAME_MAP } from './modules';
export { COURSES, COURSE_NUMBER_MAP } from './courses';

// ─── Legacy aliases (for backward compatibility with slices) ─────────────────
export const STUDENT = _STUDENTS[0];
export const SEMESTER_METAS = _SEMESTERS; // same structure

// ─── Relationship Entities ────────────────────────────────────────────────────
export { COURSE_LECTURERS } from './courseLecturers';
export { ENROLLMENTS } from './enrollments';
export { SCHEDULES } from './schedules';

// ─── Holiday Entity (static, not derived) ─────────────────────────────────────
export { HOLIDAYS, WS2025_HOLIDAYS, SS2026_HOLIDAYS } from './holidays';

// ─── Exam Entities ────────────────────────────────────────────────────────────
export { EXAMS } from './exams';
export { EXAM_REGISTRATIONS } from './examRegistrations';

// ─── Elective Entities ────────────────────────────────────────────────────────
export { ELECTIVE_SLOTS, ELECTIVE_SUMMARY } from './electiveSlots';
export { ELECTIVE_RULES, ELECTIVE_SUBSTITUTION_RULES } from './electiveRules';
export { THESIS_PREREQUISITES } from './thesisPrerequisites';

// ─── Registration Entities ────────────────────────────────────────────────────
export {
  REGISTRATION_PERIODS,
  CURRENT_REGISTRATION,
  COURSE_AVAILABILITY,
  REGISTRATIONS,
  CORE_ELECTIVE_POOL_WS27,
  CROSS_FACULTY_POOL_WS27,
} from './registrationPeriods'; // /**
 * Normalized Lecturer entity data.
 * 
 * Entity: Lecturer
 * ─────────────────────────────────────────────────────────────────────────────
 * id          — unique lecturer identifier
 * title       — academic title (Prof. Dr., Dr., etc.)
 * firstName   — first name
 * lastName    — last name
 * email       — university email
 * department  — department/faculty
 * role        — 'professor' | 'associate_professor' | 'lecturer' | 'external'
 */

export const LECTURERS = [
  {
    id: 'lec-01',
    title: 'Prof. Dr.',
    firstName: 'Thomas',
    lastName: 'Keller',
    email: 'thomas.keller@uni.li',
    department: 'Information Systems',
    role: 'professor',
  },
  {
    id: 'lec-02',
    title: 'Dr.',
    firstName: 'Nina',
    lastName: 'Hartmann',
    email: 'nina.hartmann@uni.li',
    department: 'Information Systems',
    role: 'lecturer',
  },
  {
    id: 'lec-03',
    title: 'Prof. Dr.',
    firstName: 'Marcus',
    lastName: 'Frei',
    email: 'marcus.frei@uni.li',
    department: 'Information Systems',
    role: 'professor',
  },
  {
    id: 'lec-04',
    title: 'Dr.',
    firstName: 'Felix',
    lastName: 'Gruber',
    email: 'felix.gruber@uni.li',
    department: 'Information Systems',
    role: 'lecturer',
  },
  {
    id: 'lec-05',
    title: 'Prof. Dr.',
    firstName: 'Anna',
    lastName: 'Schreiber',
    email: 'anna.schreiber@uni.li',
    department: 'Information Systems',
    role: 'professor',
  },
  {
    id: 'lec-06',
    title: 'Dr.',
    firstName: 'Lukas',
    lastName: 'Brenner',
    email: 'lukas.brenner@uni.li',
    department: 'Information Systems',
    role: 'lecturer',
  },
  {
    id: 'lec-07',
    title: 'Assoz. Prof. Dr.',
    firstName: 'David',
    lastName: 'Hofmann',
    email: 'david.hofmann@uni.li',
    department: 'Information Systems',
    role: 'associate_professor',
  },
  {
    id: 'lec-08',
    title: 'Prof. Dr.',
    firstName: 'Sandra',
    lastName: 'Mayer',
    email: 'sandra.mayer@uni.li',
    department: 'Information Systems',
    role: 'professor',
  },
  {
    id: 'lec-09',
    title: 'Prof. Dr.',
    firstName: 'Erich',
    lastName: 'Brunner',
    email: 'erich.brunner@uni.li',
    department: 'Quantitative Methods',
    role: 'professor',
  },
  {
    id: 'lec-10',
    title: 'Dr.',
    firstName: 'Peter',
    lastName: 'Hausmann',
    email: 'peter.hausmann@uni.li',
    department: 'Quantitative Methods',
    role: 'lecturer',
  },
  {
    id: 'lec-11',
    title: 'Dr.',
    firstName: 'Simon',
    lastName: 'Ritter',
    email: 'simon.ritter@uni.li',
    department: 'Information Systems',
    role: 'lecturer',
  },
  {
    id: 'lec-12',
    title: 'Dr.',
    firstName: 'Laura',
    lastName: 'Vogel',
    email: 'laura.vogel@uni.li',
    department: 'Information Systems',
    role: 'lecturer',
  },
  {
    id: 'lec-13',
    title: 'Prof. Dr.',
    firstName: 'Nikolai',
    lastName: 'Vogt',
    email: 'nikolai.vogt@uni.li',
    department: 'IT Security',
    role: 'professor',
  },
  {
    id: 'lec-14',
    title: 'Dr.',
    firstName: 'Monika',
    lastName: 'Steiner',
    email: 'monika.steiner@uni.li',
    department: 'IT Security',
    role: 'lecturer',
  },
  {
    id: 'lec-15',
    title: 'Dr.',
    firstName: 'Georg',
    lastName: 'Baumann',
    email: 'georg.baumann@uni.li',
    department: 'Law',
    role: 'lecturer',
  },
  {
    id: 'lec-16',
    title: 'Mag.',
    firstName: 'Eva',
    lastName: 'Fischer',
    email: 'eva.fischer@uni.li',
    department: 'Law',
    role: 'lecturer',
  },
  {
    id: 'lec-17',
    title: 'Prof.',
    firstName: 'Simon',
    lastName: 'Berger',
    email: 'simon.berger@uni.li',
    department: 'Information Systems',
    role: 'professor',
  },
  {
    id: 'lec-18',
    title: 'Dr.',
    firstName: 'Klaus',
    lastName: 'Richter',
    email: 'klaus.richter@uni.li',
    department: 'Research Methods',
    role: 'lecturer',
  },
  {
    id: 'lec-19',
    title: 'Dr.',
    firstName: 'Julian',
    lastName: 'Metz',
    email: 'julian.metz@uni.li',
    department: 'Data Science',
    role: 'lecturer',
  },
  {
    id: 'lec-20',
    title: 'Prof. Dr.',
    firstName: 'Anna',
    lastName: 'Schwarz',
    email: 'anna.schwarz@uni.li',
    department: 'Ethics',
    role: 'professor',
  },
  {
    id: 'lec-21',
    title: 'Prof. Dr.',
    firstName: 'Sarah',
    lastName: 'Müller',
    email: 'sarah.mueller@uni.li',
    department: 'Research Methods',
    role: 'professor',
  },
  {
    id: 'lec-22',
    title: 'Dr.',
    firstName: 'Petra',
    lastName: 'Lange',
    email: 'petra.lange@uni.li',
    department: 'Languages',
    role: 'lecturer',
  },
  {
    id: 'lec-23',
    title: '',
    firstName: 'Patrick',
    lastName: 'Walsh',
    email: 'patrick.walsh@uni.li',
    department: 'Languages',
    role: 'external',
  },
  {
    id: 'lec-24',
    title: '',
    firstName: 'Daniel',
    lastName: 'Haas',
    email: 'daniel.haas@uni.li',
    department: 'Communication',
    role: 'external',
  },
  {
    id: 'lec-25',
    title: '',
    firstName: 'Michael',
    lastName: 'Strasser',
    email: 'michael.strasser@uni.li',
    department: 'Communication',
    role: 'external',
  },
  {
    id: 'lec-26',
    title: 'Mag.',
    firstName: 'Claudia',
    lastName: 'Wenzel',
    email: 'claudia.wenzel@uni.li',
    department: 'Personal Development',
    role: 'external',
  },
  {
    id: 'lec-27',
    title: 'MSc',
    firstName: 'Tobias',
    lastName: 'Kraft',
    email: 'tobias.kraft@uni.li',
    department: 'Online Learning',
    role: 'external',
  },
];

// Helper: map display name → lecturer ID
export const LECTURER_NAME_MAP = {
  'Prof. Dr. Thomas Keller': 'lec-01',
  'Dr. Nina Hartmann': 'lec-02',
  'Prof. Dr. Marcus Frei': 'lec-03',
  'Dr. Felix Gruber': 'lec-04',
  'Prof. Dr. Felix Gruber': 'lec-04',
  'Prof. Dr. Anna Schreiber': 'lec-05',
  'Dr. Lukas Brenner': 'lec-06',
  'Lukas Brenner, PhD': 'lec-06',
  'Prof. Dr. David Hofmann': 'lec-07',
  'Assoz. Prof. Dr. David Hofmann': 'lec-07',
  'Prof. Dr. Sandra Mayer': 'lec-08',
  'Prof. Dr. Erich Brunner': 'lec-09',
  'Dr. Peter Hausmann': 'lec-10',
  'Dr. Simon Ritter': 'lec-11',
  'Dr. Laura Vogel': 'lec-12',
  'Prof. Dr. Nikolai Vogt': 'lec-13',
  'Dr. Monika Steiner': 'lec-14',
  'Dr. Georg Baumann': 'lec-15',
  'Mag. Eva Fischer': 'lec-16',
  'Prof. Simon Berger': 'lec-17',
  'Dr. Klaus Richter': 'lec-18',
  'Dr. Julian Metz': 'lec-19',
  'Prof. Dr. Anna Schwarz': 'lec-20',
  'Prof. Dr. Sarah Müller': 'lec-21',
  'Dr. Petra Lange': 'lec-22',
  'Patrick Walsh': 'lec-23',
  'Daniel Haas': 'lec-24',
  'Michael Strasser': 'lec-25',
  'Mag. Claudia Wenzel': 'lec-26',
  'Tobias Kraft MSc': 'lec-27',
}; // /**
 * Normalized Module entity data.
 * 
 * Entity: Module
 * ─────────────────────────────────────────────────────────────────────────────
 * id              — unique module identifier
 * name            — full module name
 * shortName       — abbreviated name
 * programmeId     — FK → Programme
 * type            — 'Compulsory module' | 'Core Elective' | 'Cross-Faculty Elective' | 'Cross-Programme' | 'thesis'
 * totalEcts       — total ECTS for the module
 * coordinatorId   — FK → Lecturer (module coordinator)
 */

export const MODULES = [
  // ─── Compulsory Modules ──────────────────────────────────────────────────────
  {
    id: 'mod-01',
    name: 'Digital Innovation ',
    shortName: 'DIT',
    programmeId: 'prog-mis',
    type: 'Compulsory module',
    totalEcts: 6,
    coordinatorId: 'lec-01',
  },
  {
    id: 'mod-02',
    name: 'Business Process Management',
    shortName: 'BPM',
    programmeId: 'prog-mis',
    type: 'Compulsory module',
    totalEcts: 6,
    coordinatorId: 'lec-03',
  },
  {
    id: 'mod-03',
    name: 'Management Information Systems',
    shortName: 'MIS',
    programmeId: 'prog-mis',
    type: 'Compulsory module',
    totalEcts: 3,
    coordinatorId: 'lec-05',
  },
  {
    id: 'mod-isd',
    name: 'Information Systems Development',
    shortName: 'ISD',
    programmeId: 'prog-mis',
    type: 'Compulsory module',
    totalEcts: 3,
    coordinatorId: 'lec-06',
  },
  {
    id: 'mod-04',
    name: 'Data Management',
    shortName: 'DM',
    programmeId: 'prog-mis',
    type: 'Compulsory module',
    totalEcts: 3,
    coordinatorId: 'lec-08',
  },
  {
    id: 'mod-05',
    name: 'Business Statistics',
    shortName: 'BS',
    programmeId: 'prog-mis',
    type: 'Compulsory module',
    totalEcts: 3,
    coordinatorId: 'lec-09',
  },
  {
    id: 'mod-06',
    name: 'Web-based Information Systems',
    shortName: 'WBIS',
    programmeId: 'prog-mis',
    type: 'Compulsory module',
    totalEcts: 3,
    coordinatorId: 'lec-11',
  },
  {
    id: 'mod-07',
    name: 'Data and Application Security',
    shortName: 'DAS',
    programmeId: 'prog-mis',
    type: 'Compulsory module',
    totalEcts: 6,
    coordinatorId: 'lec-13',
  },
  {
    id: 'mod-dsai',
    name: 'Data Science and Artificial Intelligence',
    shortName: 'DSAI',
    programmeId: 'prog-mis',
    type: 'Compulsory module',
    totalEcts: 6,
    coordinatorId: 'lec-07',
  },
  {
    id: 'mod-ismod',
    name: 'Information Systems Modelling',
    shortName: 'ISM',
    programmeId: 'prog-mis',
    type: 'Compulsory module',
    totalEcts: 3,
    coordinatorId: 'lec-04',
  },
  {
    id: 'mod-08',
    name: 'Emerging IT Topics',
    shortName: 'EIT',
    programmeId: 'prog-mis',
    type: 'Compulsory module',
    totalEcts: 3,
    coordinatorId: 'lec-06',
  },


  {
    id: 'mod-09',
    name: 'Research Methods',
    shortName: 'RM',
    programmeId: 'prog-mis',
    type: 'Compulsory module',
    totalEcts: 3,
    coordinatorId: 'lec-05',
  },
  {
    id: 'mod-10',
    name: 'Project Seminar',
    shortName: 'PS',
    programmeId: 'prog-mis',
    type: 'Compulsory module',
    totalEcts: 6,
    coordinatorId: 'lec-03',
  },
  {
    id: 'mod-ilab',
    name: 'Innovation Lab',
    shortName: 'ILAB',
    programmeId: 'prog-mis',
    type: 'Compulsory module',
    totalEcts: 3,
    coordinatorId: 'lec-17',
  },
  {
    id: 'mod-itleg',
    name: 'IT Law, Ethics and Governance',
    shortName: 'ITLEG',
    programmeId: 'prog-mis',
    type: 'Compulsory module',
    totalEcts: 3,
    coordinatorId: 'lec-15',
  },
  {
    id: 'mod-rm2',
    name: 'Research Methods',
    shortName: 'RM2',
    programmeId: 'prog-mis',
    type: 'Cross-Programme',
    totalEcts: 3,
    coordinatorId: 'lec-03',
  },
  {
    id: 'mod-rs',
    name: 'Research Seminar',
    shortName: 'RS',
    programmeId: 'prog-mis',
    type: 'Compulsory module',
    totalEcts: 3,
    coordinatorId: 'lec-01',
  },
  // ─── Thesis Module ──────────────────────────────────────────────────────────
  {
    id: 'mod-thesis',
    name: "Master's Thesis",
    shortName: 'Thesis',
    programmeId: 'prog-mis',
    type: 'thesis',
    totalEcts: 27,
    coordinatorId: null,
  },
  // ─── Cross-Programme Modules ──────────────────────────────────────────────────
  {
    id: 'mod-des',
    name: 'Digital Ethics & Society',
    shortName: 'DES',
    programmeId: 'prog-mis',
    type: 'Cross-Programme',
    totalEcts: 3,
    coordinatorId: 'lec-01',
  },
  {
    id: 'mod-itgc',
    name: 'IT Governance & Compliance',
    shortName: 'ITGC',
    programmeId: 'prog-mis',
    type: 'Cross-Programme',
    totalEcts: 3,
    coordinatorId: 'lec-02',
  },
  // ─── Core Elective Modules ──────────────────────────────────────────────────
  {
    id: 'mod-ce01',
    name: 'BPM and Organizational Practice',
    shortName: 'CE-BPM-OP',
    programmeId: 'prog-mis',
    type: 'Core Elective',
    totalEcts: 3,
    coordinatorId: 'lec-03',
  },
  {
    id: 'mod-ce02',
    name: 'Security Management',
    shortName: 'CE-SM',
    programmeId: 'prog-mis',
    type: 'Core Elective',
    totalEcts: 3,
    coordinatorId: 'lec-13',
  },
  {
    id: 'mod-ce03',
    name: 'AI Management, Strategy and Governance',
    shortName: 'CE-AI-MSG',
    programmeId: 'prog-mis',
    type: 'Core Elective',
    totalEcts: 3,
    coordinatorId: 'lec-07',
  },
  {
    id: 'mod-ce04',
    name: 'Deep Learning and Advanced AI Techniques',
    shortName: 'CE-DL-AI',
    programmeId: 'prog-mis',
    type: 'Core Elective',
    totalEcts: 3,
    coordinatorId: 'lec-01',
  },
  {
    id: 'mod-ce05',
    name: 'Digital Business and Transformation',
    shortName: 'CE-DBT',
    programmeId: 'prog-mis',
    type: 'Core Elective',
    totalEcts: 3,
    coordinatorId: 'lec-01',
  },
  {
    id: 'mod-ce06',
    name: 'Educational Journey',
    shortName: 'CE-EJ',
    programmeId: 'prog-mis',
    type: 'Core Elective',
    totalEcts: 3,
    coordinatorId: 'lec-01',
  },
  {
    id: 'mod-ce07',
    name: 'Advanced ISD Project',
    shortName: 'CE-AISD-PROJ',
    programmeId: 'prog-mis',
    type: 'Core Elective',
    totalEcts: 3,
    coordinatorId: 'lec-01',
  },
  {
    id: 'mod-ce08',
    name: 'Business Process Analysis',
    shortName: 'CE-BPA',
    programmeId: 'prog-mis',
    type: 'Core Elective',
    totalEcts: 3,
    coordinatorId: 'lec-01',
  },
  {
    id: 'mod-ce09',
    name: 'Process Mining',
    shortName: 'CE-PM',
    programmeId: 'prog-mis',
    type: 'Core Elective',
    totalEcts: 3,
    coordinatorId: 'lec-01',
  },
  {
    id: 'mod-ce10',
    name: 'AI and Security',
    shortName: 'CE-AI-SEC',
    programmeId: 'prog-mis',
    type: 'Core Elective',
    totalEcts: 3,
    coordinatorId: 'lec-01',
  },
  {
    id: 'mod-ce11',
    name: 'Network and System Security',
    shortName: 'CE-NSS',
    programmeId: 'prog-mis',
    type: 'Core Elective',
    totalEcts: 3,
    coordinatorId: 'lec-01',
  },
  {
    id: 'mod-ce12',
    name: 'Data Visualization',
    shortName: 'CE-DV',
    programmeId: 'prog-mis',
    type: 'Core Elective',
    totalEcts: 3,
    coordinatorId: 'lec-01',
  },
  {
    id: 'mod-ce13',
    name: 'Advanced Machine Learning',
    shortName: 'CE-AML',
    programmeId: 'prog-mis',
    type: 'Core Elective',
    totalEcts: 3,
    coordinatorId: 'lec-01',
  },
  {
    id: 'mod-ce14',
    name: 'Generative AI',
    shortName: 'CE-GAI',
    programmeId: 'prog-mis',
    type: 'Core Elective',
    totalEcts: 3,
    coordinatorId: 'lec-01',
  },
  {
    id: 'mod-ce15',
    name: 'Global Perspectives on IT and Digital Entrepreneurship',
    shortName: 'CE-GPITDE',
    programmeId: 'prog-mis',
    type: 'Core Elective',
    totalEcts: 3,
    coordinatorId: 'lec-01',
  },
  {
    id: 'mod-ce16',
    name: 'Autonomous Tools, Design, and Innovation',
    shortName: 'CE-ATDI',
    programmeId: 'prog-mis',
    type: 'Core Elective',
    totalEcts: 3,
    coordinatorId: 'lec-01',
  },
  // ─── Cross-Faculty Elective Modules ────────────────────────────────────────
  {
    id: 'mod-cf-eng1',
    name: 'Activation in English I',
    shortName: 'Eng-I',
    programmeId: 'prog-mis',
    type: 'Cross-Faculty Elective',
    totalEcts: 3,
    coordinatorId: null,
  },
  {
    id: 'mod-cf-eng2',
    name: 'Activation in English II',
    shortName: 'Eng-II',
    programmeId: 'prog-mis',
    type: 'Cross-Faculty Elective',
    totalEcts: 3,
    coordinatorId: null,
  },
  {
    id: 'mod-cf-crt1',
    name: 'Creative Thinking Tools for Success and Leadership',
    shortName: 'CreaTh',
    programmeId: 'prog-mis',
    type: 'Cross-Faculty Elective',
    totalEcts: 3,
    coordinatorId: null,
  },
  {
    id: 'mod-cf-ger1',
    name: 'German as a Foreign Language I',
    shortName: 'Ger-I',
    programmeId: 'prog-mis',
    type: 'Cross-Faculty Elective',
    totalEcts: 3,
    coordinatorId: null,
  },
  {
    id: 'mod-cf-ger2',
    name: 'German as a Foreign Language II',
    shortName: 'Ger-II',
    programmeId: 'prog-mis',
    type: 'Cross-Faculty Elective',
    totalEcts: 3,
    coordinatorId: null,
  },
  {
    id: 'mod-cf-ger3',
    name: 'German as a Foreign Language III',
    shortName: 'Ger-III',
    programmeId: 'prog-mis',
    type: 'Cross-Faculty Elective',
    totalEcts: 3,
    coordinatorId: null,
  },
  {
    id: 'mod-cf-fuh1',
    name: 'Die Kunst der guten Führung',
    shortName: 'KdgF',
    programmeId: 'prog-mis',
    type: 'Cross-Faculty Elective',
    totalEcts: 3,
    coordinatorId: null,
  },
  {
    id: 'mod-cf-esp1',
    name: 'Español Elemental I',
    shortName: 'Esp-I',
    programmeId: 'prog-mis',
    type: 'Cross-Faculty Elective',
    totalEcts: 3,
    coordinatorId: null,
  },
  {
    id: 'mod-cf-esp2',
    name: 'Español Elemental II',
    shortName: 'Esp-II',
    programmeId: 'prog-mis',
    type: 'Cross-Faculty Elective',
    totalEcts: 3,
    coordinatorId: null,
  },
  {
    id: 'mod-cf-gt1',
    name: 'Game Theory & Strategic Decisions',
    shortName: 'GameTh',
    programmeId: 'prog-mis',
    type: 'Cross-Faculty Elective',
    totalEcts: 3,
    coordinatorId: null,
  },
  {
    id: 'mod-cf-ki1',
    name: 'KI in den Medien: Chancen, Risiken, Perspektiven',
    shortName: 'KI-Med',
    programmeId: 'prog-mis',
    type: 'Cross-Faculty Elective',
    totalEcts: 3,
    coordinatorId: null,
  },
  {
    id: 'mod-cf-ai1',
    name: 'Understanding AI, Shaping AI: Interdisciplinary Practice for AI Literacy',
    shortName: 'AI-Lit',
    programmeId: 'prog-mis',
    type: 'Cross-Faculty Elective',
    totalEcts: 3,
    coordinatorId: null,
  },
  {
    id: 'mod-cf-milsa1',
    name: 'MILSA for Outgoing Students (Study Abroad WS 2026/27)',
    shortName: 'MILSA-Out',
    programmeId: 'prog-mis',
    type: 'Cross-Faculty Elective',
    totalEcts: 3,
    coordinatorId: null,
  },
  {
    id: 'mod-cf-milsa2',
    name: 'MILSA only for Incoming Students',
    shortName: 'MILSA-In',
    programmeId: 'prog-mis',
    type: 'Cross-Faculty Elective',
    totalEcts: 3,
    coordinatorId: null,
  },
  {
    id: 'mod-cf-pres1',
    name: 'Presentation Skills Training',
    shortName: 'PresSkl',
    programmeId: 'prog-mis',
    type: 'Cross-Faculty Elective',
    totalEcts: 3,
    coordinatorId: null,
  },
  {
    id: 'mod-cf-pro1',
    name: 'Professional Skills for the Workplace',
    shortName: 'ProSkl',
    programmeId: 'prog-mis',
    type: 'Cross-Faculty Elective',
    totalEcts: 3,
    coordinatorId: null,
  },
  {
    id: 'mod-cf-radio1',
    name: 'Campus Radio – Podcast & Audio Communication Basics',
    shortName: 'Radio',
    programmeId: 'prog-mis',
    type: 'Cross-Faculty Elective',
    totalEcts: 3,
    coordinatorId: null,
  },
  {
    id: 'mod-cf-coach1',
    name: 'Coaching – Grundlagen, Methoden und Anwendung',
    shortName: 'Coach',
    programmeId: 'prog-mis',
    type: 'Cross-Faculty Elective',
    totalEcts: 3,
    coordinatorId: null,
  },
];

// Helper: module name → module ID
export const MODULE_NAME_MAP = {
  'Digital Innovation': 'mod-01',
  'Business Process Management': 'mod-02',
  'Management Information Systems': 'mod-03',
  'Data Management': 'mod-04',
  'Business Statistics': 'mod-05',
  'Web-based Information Systems': 'mod-06',
  'Data and Application Security': 'mod-07',
  'Emerging IT Topics': 'mod-08',
  'Research Methods': 'mod-09',
  'Project Seminar': 'mod-10',
  'Information Systems Development': 'mod-isd',
  'Information Systems Modelling': 'mod-ismod',
  'Data Science and Artificial Intelligence': 'mod-dsai',
  'IT Law, Ethics and Governance': 'mod-itleg',
  'Innovation Lab': 'mod-ilab',
  'Research Seminar': 'mod-rs',
  'Digital Ethics & Society': 'mod-des',
  'IT Governance & Compliance': 'mod-itgc',
};

 // /**
 * Registration-layer mock data — WS 2026/27.
 *
 * Augments base curriculum data (coreElectives, semesterCourses) with
 * registration-specific fields: seats, eligibility, schedule for conflict
 * detection, and the ECTS accounting rules for electives.
 *
 * Replace with Supabase queries once the backend is available.
 */

// ─── Registration window ──────────────────────────────────────────────────────

export const REGISTRATION_WINDOW = {
  semester:       'WS 2026/27',
  openDate:       '8 March 2026',
  closeDate:      '15 June 2026',
  deregDeadline:  '1 October 2026',
  isOpen:         true,
  isUpcoming:     false,
};

// ─── ECTS rules & accounting ──────────────────────────────────────────────────

/**
 * Replacement rule: exactly ONE Core Elective slot may substitute for
 * exactly ONE Cross-Faculty slot (lifetime, not per semester).
 * usedCount tracks how many substitutions have been applied.
 */
export const ELECTIVE_RULES = {
  coreElective: {
    label:      'Core Electives',
    totalSlots: 6,
    ectsPerSlot: 3,
    required:   18,
    completed:  3,   // CE-I completed
    registered: 3,   // CE-II registered (current semester)
    pending:    4,   // CE-III – CE-VI open
  },
  crossFaculty: {
    label:      'Cross-Faculty Electives',
    totalSlots: 4,
    ectsPerSlot: 3,
    required:   12,
    completed:  3,   // CF-I completed
    registered: 3,   // CF-II registered (current semester)
    pending:    2,   // CF-III, CF-IV open
  },
  replacementRule: {
    maxAllowed:  1,
    usedCount:   0,
    description: 'One Core Elective slot may substitute for one Cross-Faculty slot (once only).',
  },
};

// ─── WS 2026/27 schedule slots (for intra-semester conflict detection) ─────────

export const TIME_SLOTS = ['08:30–11:45', '12:30–15:45', '16:00–19:15'];

// ─── Compulsory courses available for registration (WS 2026/27) ────────────────

export const COMPULSORY_COURSES = [
  {
    id:           'ws27-m1',
    courseNumber: '6112801',
    name:         'Digital Ethics & Society',
    ects:         6,
    language:     'English',
    lecturer:     'Prof. Dr. Anna Schwarz',
    schedule:     { day: 'Thu', slot: '08:30–11:45', room: 'H3' },
    seats:        { available: 22, total: 30 },
    prerequisites: [],
    prereqsMet:   true,
    status:       'eligible',
    description:  'Ethical, social, and legal implications of digital systems at individual, organisational, and societal level.',
  },
  {
    id:           'ws27-m2',
    courseNumber: '6112802',
    name:         'IT Governance & Compliance',
    ects:         6,
    language:     'English',
    lecturer:     'Prof. Dr. Nikolai Vogt',
    schedule:     { day: 'Thu', slot: '12:30–15:45', room: 'B3' },
    seats:        { available: 18, total: 30 },
    prerequisites: [],
    prereqsMet:   true,
    status:       'eligible',
    description:  'COBIT, ISO 38500, regulatory compliance frameworks, and IT risk management at enterprise scale.',
  },
  {
    id:           'ws27-m3',
    courseNumber: '6112803',
    name:         'Research Methods',
    ects:         3,
    language:     'English',
    lecturer:     'Prof. Dr. Sarah Müller',
    schedule:     { day: 'Wed', slot: '10:00–12:15', room: 'A4' },
    seats:        { available: 0, total: 30 },
    prerequisites: [],
    prereqsMet:   true,
    status:       'full',
    description:  'Qualitative and quantitative research design, scientific writing, and empirical methods in IS research.',
  },
  {
    id:           'ws27-m4',
    courseNumber: '6112804',
    name:         'Data Governance',
    ects:         3,
    language:     'English',
    lecturer:     'Dr. Felix Gruber',
    schedule:     { day: 'Fri', slot: '08:30–11:45', room: 'H6' },
    seats:        { available: 14, total: 25 },
    prerequisites: ['Systems Analysis'],
    prereqsMet:   false,   // student is currently retaking Systems Analysis in SS 2026
    status:       'missing-prereq',
    description:  'Data ownership, stewardship policies, master data management, and regulatory compliance (GDPR).',
  },
];

// ─── Pending slots that need selection for WS 26/27 ──────────────────────────

// CE-III and CE-IV can be filled in WS 26/27 (semester 3)
export const PENDING_CE_SLOTS = ['CE-III', 'CE-IV'];

// CF-III can be filled in WS 26/27 (semester 3) — can also swap for a CE
export const PENDING_CF_SLOTS = ['CF-III'];

// ─── Conflict detection helper ────────────────────────────────────────────────

/**
 * Returns the name of the conflicting course if `newSlot` overlaps with an
 * already-selected slot in `selectedSlots`, otherwise null.
 *
 * @param {{ day: string, slot: string }} newSlot
 * @param {Array<{ day: string, slot: string, name: string }>} selectedSlots
 */
export function detectConflict(newSlot, selectedSlots) {
  if (!newSlot) return null;
  return (
    selectedSlots.find(
      (s) => s.day === newSlot.day && s.slot === newSlot.slot,
    )?.name ?? null
  );
} // /**
 * Normalized Schedule entity data.
 * 
 * Entity: Schedule
 * ─────────────────────────────────────────────────────────────────────────────
 * id          — unique schedule identifier
 * courseId    — FK → Course
 * semesterId  — FK → Semester
 * date        — date of session (YYYY-MM-DD)
 * dayOfWeek   — 'Mon' | 'Tue' | 'Wed' | 'Thu' | 'Fri' | 'Sat'
 * timeSlot    — time range (e.g., '08:30–11:45')
 * room        — room/location
 */


export const SCHEDULES = [
  // ─── SS 2026/27 Schedules ─────────────────────────────────────────────────
  // Data and Application Security (Thu 08:30)
  { id: 'sch-001', courseId: 'crs-008', semesterId: 'sem-ss2026', date: '2026-03-05', dayOfWeek: 'Thu', timeSlot: '08:30–11:45', room: 'H3' },
  { id: 'sch-002', courseId: 'crs-008', semesterId: 'sem-ss2026', date: '2026-03-12', dayOfWeek: 'Thu', timeSlot: '08:30–11:45', room: 'H3' },
  { id: 'sch-003', courseId: 'crs-008', semesterId: 'sem-ss2026', date: '2026-03-26', dayOfWeek: 'Thu', timeSlot: '08:30–11:45', room: 'H3' },
  { id: 'sch-004', courseId: 'crs-008', semesterId: 'sem-ss2026', date: '2026-04-02', dayOfWeek: 'Thu', timeSlot: '08:30–11:45', room: 'H3' },
  { id: 'sch-005', courseId: 'crs-008', semesterId: 'sem-ss2026', date: '2026-04-09', dayOfWeek: 'Thu', timeSlot: '08:30–11:45', room: 'H3' },
  { id: 'sch-006', courseId: 'crs-008', semesterId: 'sem-ss2026', date: '2026-04-16', dayOfWeek: 'Thu', timeSlot: '08:30–11:45', room: 'H3' },
  { id: 'sch-007', courseId: 'crs-008', semesterId: 'sem-ss2026', date: '2026-04-23', dayOfWeek: 'Thu', timeSlot: '08:30–11:45', room: 'H3' },
  { id: 'sch-008', courseId: 'crs-008', semesterId: 'sem-ss2026', date: '2026-04-30', dayOfWeek: 'Thu', timeSlot: '08:30–11:45', room: 'H3' },
  { id: 'sch-009', courseId: 'crs-008', semesterId: 'sem-ss2026', date: '2026-05-07', dayOfWeek: 'Thu', timeSlot: '08:30–11:45', room: 'H3' },
  { id: 'sch-010', courseId: 'crs-008', semesterId: 'sem-ss2026', date: '2026-05-21', dayOfWeek: 'Thu', timeSlot: '08:30–11:45', room: 'H3' },
  { id: 'sch-011', courseId: 'crs-008', semesterId: 'sem-ss2026', date: '2026-05-28', dayOfWeek: 'Thu', timeSlot: '08:30–11:45', room: 'H3' },
  { id: 'sch-150', courseId: 'crs-008', semesterId: 'sem-ss2026', date: '2026-06-04', dayOfWeek: 'Thu', timeSlot: '08:30–11:45', room: 'H3' },

  // Data Science and Artificial Intelligence (Tue 08:30)
  { id: 'sch-023', courseId: 'crs-009', semesterId: 'sem-ss2026', date: '2026-03-03', dayOfWeek: 'Tue', timeSlot: '08:30–11:45', room: 'B2' },
  { id: 'sch-024', courseId: 'crs-009', semesterId: 'sem-ss2026', date: '2026-03-10', dayOfWeek: 'Tue', timeSlot: '08:30–11:45', room: 'B2' },
  { id: 'sch-025', courseId: 'crs-009', semesterId: 'sem-ss2026', date: '2026-03-17', dayOfWeek: 'Tue', timeSlot: '08:30–11:45', room: 'B2' },
  { id: 'sch-026', courseId: 'crs-009', semesterId: 'sem-ss2026', date: '2026-03-24', dayOfWeek: 'Tue', timeSlot: '08:30–11:45', room: 'B2' },
  { id: 'sch-027', courseId: 'crs-009', semesterId: 'sem-ss2026', date: '2026-03-31', dayOfWeek: 'Tue', timeSlot: '08:30–11:45', room: 'B2' },
  { id: 'sch-028', courseId: 'crs-009', semesterId: 'sem-ss2026', date: '2026-04-07', dayOfWeek: 'Tue', timeSlot: '08:30–11:45', room: 'B2' },
  { id: 'sch-029', courseId: 'crs-009', semesterId: 'sem-ss2026', date: '2026-04-14', dayOfWeek: 'Tue', timeSlot: '08:30–11:45', room: 'B2' },
  { id: 'sch-030', courseId: 'crs-009', semesterId: 'sem-ss2026', date: '2026-04-21', dayOfWeek: 'Tue', timeSlot: '08:30–11:45', room: 'B2' },
  { id: 'sch-031', courseId: 'crs-009', semesterId: 'sem-ss2026', date: '2026-04-28', dayOfWeek: 'Tue', timeSlot: '08:30–11:45', room: 'B2' },
  { id: 'sch-032', courseId: 'crs-009', semesterId: 'sem-ss2026', date: '2026-05-05', dayOfWeek: 'Tue', timeSlot: '08:30–11:45', room: 'B2' },
  { id: 'sch-033', courseId: 'crs-009', semesterId: 'sem-ss2026', date: '2026-05-19', dayOfWeek: 'Tue', timeSlot: '08:30–11:45', room: 'B2' },
  { id: 'sch-151', courseId: 'crs-009', semesterId: 'sem-ss2026', date: '2026-06-02', dayOfWeek: 'Tue', timeSlot: '08:30–11:45', room: 'B2' },

  // Information Systems Modelling (Mon 14:00)
  { id: 'sch-012', courseId: 'crs-010', semesterId: 'sem-ss2026', date: '2026-03-02', dayOfWeek: 'Mon', timeSlot: '14:00–16:15', room: 'C3' },
  { id: 'sch-066', courseId: 'crs-010', semesterId: 'sem-ss2026', date: '2026-03-16', dayOfWeek: 'Mon', timeSlot: '14:00–16:15', room: 'C3' },
  { id: 'sch-067', courseId: 'crs-010', semesterId: 'sem-ss2026', date: '2026-03-30', dayOfWeek: 'Mon', timeSlot: '14:00–16:15', room: 'C3' },
  { id: 'sch-068', courseId: 'crs-010', semesterId: 'sem-ss2026', date: '2026-04-20', dayOfWeek: 'Mon', timeSlot: '14:00–16:15', room: 'C3' },
  { id: 'sch-069', courseId: 'crs-010', semesterId: 'sem-ss2026', date: '2026-05-04', dayOfWeek: 'Mon', timeSlot: '14:00–16:15', room: 'C3' },
  { id: 'sch-152', courseId: 'crs-010', semesterId: 'sem-ss2026', date: '2026-05-18', dayOfWeek: 'Mon', timeSlot: '14:00–16:15', room: 'C3' },
  { id: 'sch-013', courseId: 'crs-007', semesterId: 'sem-ss2026', date: '2026-03-06', dayOfWeek: 'Fri', timeSlot: '08:30–11:45', room: 'H6' },
  { id: 'sch-014', courseId: 'crs-007', semesterId: 'sem-ss2026', date: '2026-03-13', dayOfWeek: 'Fri', timeSlot: '08:30–11:45', room: 'H6' },
  { id: 'sch-015', courseId: 'crs-007', semesterId: 'sem-ss2026', date: '2026-03-20', dayOfWeek: 'Fri', timeSlot: '08:30–11:45', room: 'H6' },
  { id: 'sch-016', courseId: 'crs-007', semesterId: 'sem-ss2026', date: '2026-03-27', dayOfWeek: 'Fri', timeSlot: '08:30–11:45', room: 'H6' },
  { id: 'sch-017', courseId: 'crs-007', semesterId: 'sem-ss2026', date: '2026-04-10', dayOfWeek: 'Fri', timeSlot: '08:30–11:45', room: 'H6' },
  { id: 'sch-018', courseId: 'crs-007', semesterId: 'sem-ss2026', date: '2026-04-17', dayOfWeek: 'Fri', timeSlot: '08:30–11:45', room: 'H6' },
  { id: 'sch-019', courseId: 'crs-007', semesterId: 'sem-ss2026', date: '2026-04-24', dayOfWeek: 'Fri', timeSlot: '08:30–11:45', room: 'H6' },
  { id: 'sch-020', courseId: 'crs-007', semesterId: 'sem-ss2026', date: '2026-05-08', dayOfWeek: 'Fri', timeSlot: '08:30–11:45', room: 'H6' },
  { id: 'sch-021', courseId: 'crs-007', semesterId: 'sem-ss2026', date: '2026-05-22', dayOfWeek: 'Fri', timeSlot: '08:30–11:45', room: 'H6' },
  { id: 'sch-022', courseId: 'crs-007', semesterId: 'sem-ss2026', date: '2026-05-29', dayOfWeek: 'Fri', timeSlot: '08:30–11:45', room: 'H6' },

  // Emerging IT Topics (Thu 12:30)
  { id: 'sch-034', courseId: 'crs-012', semesterId: 'sem-ss2026', date: '2026-02-12', dayOfWeek: 'Thu', timeSlot: '12:30–15:45', room: 'H6' },
  { id: 'sch-035', courseId: 'crs-012', semesterId: 'sem-ss2026', date: '2026-02-19', dayOfWeek: 'Thu', timeSlot: '12:30–15:45', room: 'H6' },
  { id: 'sch-036', courseId: 'crs-012', semesterId: 'sem-ss2026', date: '2026-02-26', dayOfWeek: 'Thu', timeSlot: '12:30–15:45', room: 'H6' },
  { id: 'sch-037', courseId: 'crs-012', semesterId: 'sem-ss2026', date: '2026-03-05', dayOfWeek: 'Thu', timeSlot: '12:30–15:45', room: 'H6' },
  { id: 'sch-038', courseId: 'crs-012', semesterId: 'sem-ss2026', date: '2026-03-12', dayOfWeek: 'Thu', timeSlot: '12:30–15:45', room: 'H6' },
  { id: 'sch-039', courseId: 'crs-012', semesterId: 'sem-ss2026', date: '2026-03-19', dayOfWeek: 'Thu', timeSlot: '12:30–15:45', room: 'H6' },

  // IT Law, Ethics & Governance (Fri 12:30)
  { id: 'sch-046', courseId: 'crs-011', semesterId: 'sem-ss2026', date: '2026-03-06', dayOfWeek: 'Fri', timeSlot: '12:30–15:45', room: 'A2' },
  { id: 'sch-047', courseId: 'crs-011', semesterId: 'sem-ss2026', date: '2026-03-13', dayOfWeek: 'Fri', timeSlot: '12:30–15:45', room: 'A2' },
  { id: 'sch-048', courseId: 'crs-011', semesterId: 'sem-ss2026', date: '2026-03-20', dayOfWeek: 'Fri', timeSlot: '12:30–15:45', room: 'A2' },
  { id: 'sch-049', courseId: 'crs-011', semesterId: 'sem-ss2026', date: '2026-03-27', dayOfWeek: 'Fri', timeSlot: '12:30–15:45', room: 'A2' },
  { id: 'sch-050', courseId: 'crs-011', semesterId: 'sem-ss2026', date: '2026-04-10', dayOfWeek: 'Fri', timeSlot: '12:30–15:45', room: 'A2' },
  { id: 'sch-051', courseId: 'crs-011', semesterId: 'sem-ss2026', date: '2026-04-17', dayOfWeek: 'Fri', timeSlot: '12:30–15:45', room: 'A2' },
  { id: 'sch-052', courseId: 'crs-011', semesterId: 'sem-ss2026', date: '2026-04-24', dayOfWeek: 'Fri', timeSlot: '12:30–15:45', room: 'A2' },
  { id: 'sch-053', courseId: 'crs-011', semesterId: 'sem-ss2026', date: '2026-05-08', dayOfWeek: 'Fri', timeSlot: '12:30–15:45', room: 'A2' },
  { id: 'sch-054', courseId: 'crs-011', semesterId: 'sem-ss2026', date: '2026-05-22', dayOfWeek: 'Fri', timeSlot: '12:30–15:45', room: 'A2' },
  { id: 'sch-055', courseId: 'crs-011', semesterId: 'sem-ss2026', date: '2026-05-29', dayOfWeek: 'Fri', timeSlot: '12:30–15:45', room: 'A2' },

  // Activation in English I - Cross-Faculty (Sat 12:30)
  { id: 'sch-056', courseId: 'cf-eng-1', semesterId: 'sem-ss2026', date: '2026-03-07', dayOfWeek: 'Sat', timeSlot: '12:30–15:45', room: 'S1' },
  { id: 'sch-057', courseId: 'cf-eng-1', semesterId: 'sem-ss2026', date: '2026-03-14', dayOfWeek: 'Sat', timeSlot: '12:30–15:45', room: 'S1' },
  { id: 'sch-058', courseId: 'cf-eng-1', semesterId: 'sem-ss2026', date: '2026-03-21', dayOfWeek: 'Sat', timeSlot: '12:30–15:45', room: 'S1' },
  { id: 'sch-059', courseId: 'cf-eng-1', semesterId: 'sem-ss2026', date: '2026-03-28', dayOfWeek: 'Sat', timeSlot: '12:30–15:45', room: 'S1' },
  { id: 'sch-060', courseId: 'cf-eng-1', semesterId: 'sem-ss2026', date: '2026-04-04', dayOfWeek: 'Sat', timeSlot: '12:30–15:45', room: 'S1' },
  { id: 'sch-061', courseId: 'cf-eng-1', semesterId: 'sem-ss2026', date: '2026-04-11', dayOfWeek: 'Sat', timeSlot: '12:30–15:45', room: 'S1' },
  { id: 'sch-062', courseId: 'cf-eng-1', semesterId: 'sem-ss2026', date: '2026-04-25', dayOfWeek: 'Sat', timeSlot: '12:30–15:45', room: 'S1' },
  { id: 'sch-063', courseId: 'cf-eng-1', semesterId: 'sem-ss2026', date: '2026-05-02', dayOfWeek: 'Sat', timeSlot: '12:30–15:45', room: 'S1' },
  { id: 'sch-064', courseId: 'cf-eng-1', semesterId: 'sem-ss2026', date: '2026-05-09', dayOfWeek: 'Sat', timeSlot: '12:30–15:45', room: 'S1' },
  { id: 'sch-065', courseId: 'cf-eng-1', semesterId: 'sem-ss2026', date: '2026-05-16', dayOfWeek: 'Sat', timeSlot: '12:30–15:45', room: 'S1' },

  // Innovation Lab (Sat 08:30)
  { id: 'sch-040', courseId: 'crs-013', semesterId: 'sem-ss2026', date: '2026-03-07', dayOfWeek: 'Sat', timeSlot: '08:30–11:45', room: 'Innovation Hub' },
  { id: 'sch-041', courseId: 'crs-013', semesterId: 'sem-ss2026', date: '2026-03-14', dayOfWeek: 'Sat', timeSlot: '08:30–11:45', room: 'Innovation Hub' },
  { id: 'sch-042', courseId: 'crs-013', semesterId: 'sem-ss2026', date: '2026-03-21', dayOfWeek: 'Sat', timeSlot: '08:30–11:45', room: 'Innovation Hub' },
  { id: 'sch-043', courseId: 'crs-013', semesterId: 'sem-ss2026', date: '2026-03-28', dayOfWeek: 'Sat', timeSlot: '08:30–11:45', room: 'Innovation Hub' },
  { id: 'sch-044', courseId: 'crs-013', semesterId: 'sem-ss2026', date: '2026-04-18', dayOfWeek: 'Sat', timeSlot: '08:30–11:45', room: 'Innovation Hub' },
  { id: 'sch-045', courseId: 'crs-013', semesterId: 'sem-ss2026', date: '2026-05-09', dayOfWeek: 'Sat', timeSlot: '08:30–11:45', room: 'Innovation Hub' },

  // ─── WS 2026/27 Schedules (compulsory courses) ─────────────────────────────────
  // crs-017: Digital Ethics & Society (Thu 08:30)
  { id: 'sch-070', courseId: 'crs-017', semesterId: 'sem-ws2026', date: '2026-10-08', dayOfWeek: 'Thu', timeSlot: '08:30–11:45', room: 'H3' },
  { id: 'sch-071', courseId: 'crs-017', semesterId: 'sem-ws2026', date: '2026-10-15', dayOfWeek: 'Thu', timeSlot: '08:30–11:45', room: 'H3' },
  { id: 'sch-072', courseId: 'crs-017', semesterId: 'sem-ws2026', date: '2026-10-22', dayOfWeek: 'Thu', timeSlot: '08:30–11:45', room: 'H3' },
  { id: 'sch-073', courseId: 'crs-017', semesterId: 'sem-ws2026', date: '2026-10-29', dayOfWeek: 'Thu', timeSlot: '08:30–11:45', room: 'H3' },
  { id: 'sch-074', courseId: 'crs-017', semesterId: 'sem-ws2026', date: '2026-11-05', dayOfWeek: 'Thu', timeSlot: '08:30–11:45', room: 'H3' },
  { id: 'sch-075', courseId: 'crs-017', semesterId: 'sem-ws2026', date: '2026-11-12', dayOfWeek: 'Thu', timeSlot: '08:30–11:45', room: 'H3' },

  // crs-018: IT Governance & Compliance (Thu 12:30)
  { id: 'sch-080', courseId: 'crs-018', semesterId: 'sem-ws2026', date: '2026-10-08', dayOfWeek: 'Thu', timeSlot: '12:30–15:45', room: 'B3' },
  { id: 'sch-081', courseId: 'crs-018', semesterId: 'sem-ws2026', date: '2026-10-15', dayOfWeek: 'Thu', timeSlot: '12:30–15:45', room: 'B3' },
  { id: 'sch-082', courseId: 'crs-018', semesterId: 'sem-ws2026', date: '2026-10-22', dayOfWeek: 'Thu', timeSlot: '12:30–15:45', room: 'B3' },
  { id: 'sch-083', courseId: 'crs-018', semesterId: 'sem-ws2026', date: '2026-10-29', dayOfWeek: 'Thu', timeSlot: '12:30–15:45', room: 'B3' },
  { id: 'sch-084', courseId: 'crs-018', semesterId: 'sem-ws2026', date: '2026-11-05', dayOfWeek: 'Thu', timeSlot: '12:30–15:45', room: 'B3' },
  { id: 'sch-085', courseId: 'crs-018', semesterId: 'sem-ws2026', date: '2026-11-12', dayOfWeek: 'Thu', timeSlot: '12:30–15:45', room: 'B3' },

  // crs-019: Research Methods (Wed 10:00)
  { id: 'sch-090', courseId: 'crs-019', semesterId: 'sem-ws2026', date: '2026-10-07', dayOfWeek: 'Wed', timeSlot: '10:00–12:15', room: 'A4' },
  { id: 'sch-091', courseId: 'crs-019', semesterId: 'sem-ws2026', date: '2026-10-14', dayOfWeek: 'Wed', timeSlot: '10:00–12:15', room: 'A4' },
  { id: 'sch-092', courseId: 'crs-019', semesterId: 'sem-ws2026', date: '2026-10-21', dayOfWeek: 'Wed', timeSlot: '10:00–12:15', room: 'A4' },
  { id: 'sch-093', courseId: 'crs-019', semesterId: 'sem-ws2026', date: '2026-10-28', dayOfWeek: 'Wed', timeSlot: '10:00–12:15', room: 'A4' },
  { id: 'sch-094', courseId: 'crs-019', semesterId: 'sem-ws2026', date: '2026-11-04', dayOfWeek: 'Wed', timeSlot: '10:00–12:15', room: 'A4' },
  { id: 'sch-095', courseId: 'crs-019', semesterId: 'sem-ws2026', date: '2026-11-11', dayOfWeek: 'Wed', timeSlot: '10:00–12:15', room: 'A4' },

  // crs-020: Advanced Systems Engineering (Fri 08:30)
  { id: 'sch-100', courseId: 'crs-020', semesterId: 'sem-ws2026', date: '2026-10-09', dayOfWeek: 'Fri', timeSlot: '08:30–11:45', room: 'C2' },
  { id: 'sch-101', courseId: 'crs-020', semesterId: 'sem-ws2026', date: '2026-10-16', dayOfWeek: 'Fri', timeSlot: '08:30–11:45', room: 'C2' },
  { id: 'sch-102', courseId: 'crs-020', semesterId: 'sem-ws2026', date: '2026-10-23', dayOfWeek: 'Fri', timeSlot: '08:30–11:45', room: 'C2' },
  { id: 'sch-103', courseId: 'crs-020', semesterId: 'sem-ws2026', date: '2026-10-30', dayOfWeek: 'Fri', timeSlot: '08:30–11:45', room: 'C2' },
  { id: 'sch-104', courseId: 'crs-020', semesterId: 'sem-ws2026', date: '2026-11-06', dayOfWeek: 'Fri', timeSlot: '08:30–11:45', room: 'C2' },
  { id: 'sch-105', courseId: 'crs-020', semesterId: 'sem-ws2026', date: '2026-11-13', dayOfWeek: 'Fri', timeSlot: '08:30–11:45', room: 'C2' },

  // ─── WS 2026/27 Schedules (older compulsory courses re-offered) ─────────────
  // crs-003: Management Information Systems (Mon 08:30)
  { id: 'sch-110', courseId: 'crs-003', semesterId: 'sem-ws2026', date: '2026-09-07', dayOfWeek: 'Mon', timeSlot: '08:30–11:45', room: 'A1' },
  { id: 'sch-111', courseId: 'crs-003', semesterId: 'sem-ws2026', date: '2026-09-14', dayOfWeek: 'Mon', timeSlot: '08:30–11:45', room: 'A1' },
  { id: 'sch-112', courseId: 'crs-003', semesterId: 'sem-ws2026', date: '2026-09-21', dayOfWeek: 'Mon', timeSlot: '08:30–11:45', room: 'A1' },
  { id: 'sch-153', courseId: 'crs-003', semesterId: 'sem-ws2026', date: '2026-09-28', dayOfWeek: 'Mon', timeSlot: '08:30–11:45', room: 'A1' },
  { id: 'sch-154', courseId: 'crs-003', semesterId: 'sem-ws2026', date: '2026-10-05', dayOfWeek: 'Mon', timeSlot: '08:30–11:45', room: 'A1' },
  { id: 'sch-155', courseId: 'crs-003', semesterId: 'sem-ws2026', date: '2026-10-12', dayOfWeek: 'Mon', timeSlot: '08:30–11:45', room: 'A1' },
  // crs-004: Information Systems Development (Mon 12:30)
  { id: 'sch-115', courseId: 'crs-004', semesterId: 'sem-ws2026', date: '2026-09-07', dayOfWeek: 'Mon', timeSlot: '12:30–15:45', room: 'A2' },
  { id: 'sch-116', courseId: 'crs-004', semesterId: 'sem-ws2026', date: '2026-09-14', dayOfWeek: 'Mon', timeSlot: '12:30–15:45', room: 'A2' },
  { id: 'sch-117', courseId: 'crs-004', semesterId: 'sem-ws2026', date: '2026-09-21', dayOfWeek: 'Mon', timeSlot: '12:30–15:45', room: 'A2' },
  { id: 'sch-156', courseId: 'crs-004', semesterId: 'sem-ws2026', date: '2026-09-28', dayOfWeek: 'Mon', timeSlot: '12:30–15:45', room: 'A2' },
  { id: 'sch-157', courseId: 'crs-004', semesterId: 'sem-ws2026', date: '2026-10-05', dayOfWeek: 'Mon', timeSlot: '12:30–15:45', room: 'A2' },
  { id: 'sch-158', courseId: 'crs-004', semesterId: 'sem-ws2026', date: '2026-10-12', dayOfWeek: 'Mon', timeSlot: '12:30–15:45', room: 'A2' },
  // crs-005: Data Management (Tue 08:30)
  { id: 'sch-120', courseId: 'crs-005', semesterId: 'sem-ws2026', date: '2026-09-08', dayOfWeek: 'Tue', timeSlot: '08:30–11:45', room: 'B4' },
  { id: 'sch-121', courseId: 'crs-005', semesterId: 'sem-ws2026', date: '2026-09-15', dayOfWeek: 'Tue', timeSlot: '08:30–11:45', room: 'B4' },
  { id: 'sch-122', courseId: 'crs-005', semesterId: 'sem-ws2026', date: '2026-09-22', dayOfWeek: 'Tue', timeSlot: '08:30–11:45', room: 'B4' },
  { id: 'sch-159', courseId: 'crs-005', semesterId: 'sem-ws2026', date: '2026-09-29', dayOfWeek: 'Tue', timeSlot: '08:30–11:45', room: 'B4' },
  { id: 'sch-160', courseId: 'crs-005', semesterId: 'sem-ws2026', date: '2026-10-06', dayOfWeek: 'Tue', timeSlot: '08:30–11:45', room: 'B4' },
  { id: 'sch-161', courseId: 'crs-005', semesterId: 'sem-ws2026', date: '2026-10-13', dayOfWeek: 'Tue', timeSlot: '08:30–11:45', room: 'B4' },
  // crs-007: Web-based Information Systems (Fri 08:30)
  { id: 'sch-125', courseId: 'crs-007', semesterId: 'sem-ws2026', date: '2026-09-11', dayOfWeek: 'Fri', timeSlot: '08:30–11:45', room: 'H6' },
  { id: 'sch-126', courseId: 'crs-007', semesterId: 'sem-ws2026', date: '2026-09-18', dayOfWeek: 'Fri', timeSlot: '08:30–11:45', room: 'H6' },
  { id: 'sch-127', courseId: 'crs-007', semesterId: 'sem-ws2026', date: '2026-09-25', dayOfWeek: 'Fri', timeSlot: '08:30–11:45', room: 'H6' },
  { id: 'sch-162', courseId: 'crs-007', semesterId: 'sem-ws2026', date: '2026-10-02', dayOfWeek: 'Fri', timeSlot: '08:30–11:45', room: 'H6' },
  { id: 'sch-163', courseId: 'crs-007', semesterId: 'sem-ws2026', date: '2026-10-09', dayOfWeek: 'Fri', timeSlot: '08:30–11:45', room: 'H6' },
  { id: 'sch-164', courseId: 'crs-007', semesterId: 'sem-ws2026', date: '2026-10-16', dayOfWeek: 'Fri', timeSlot: '08:30–11:45', room: 'H6' },
  // crs-011: IT Law, Ethics and Governance (Fri 12:30)
  { id: 'sch-130', courseId: 'crs-011', semesterId: 'sem-ws2026', date: '2026-09-11', dayOfWeek: 'Fri', timeSlot: '12:30–15:45', room: 'A2' },
  { id: 'sch-131', courseId: 'crs-011', semesterId: 'sem-ws2026', date: '2026-09-18', dayOfWeek: 'Fri', timeSlot: '12:30–15:45', room: 'A2' },
  { id: 'sch-132', courseId: 'crs-011', semesterId: 'sem-ws2026', date: '2026-09-25', dayOfWeek: 'Fri', timeSlot: '12:30–15:45', room: 'A2' },
  { id: 'sch-165', courseId: 'crs-011', semesterId: 'sem-ws2026', date: '2026-10-02', dayOfWeek: 'Fri', timeSlot: '12:30–15:45', room: 'A2' },
  { id: 'sch-166', courseId: 'crs-011', semesterId: 'sem-ws2026', date: '2026-10-09', dayOfWeek: 'Fri', timeSlot: '12:30–15:45', room: 'A2' },
  { id: 'sch-167', courseId: 'crs-011', semesterId: 'sem-ws2026', date: '2026-10-16', dayOfWeek: 'Fri', timeSlot: '12:30–15:45', room: 'A2' },
  // crs-014: Research Methods seminar (Tue 12:30)
  { id: 'sch-135', courseId: 'crs-014', semesterId: 'sem-ws2026', date: '2026-09-08', dayOfWeek: 'Tue', timeSlot: '12:30–15:45', room: 'C4' },
  { id: 'sch-136', courseId: 'crs-014', semesterId: 'sem-ws2026', date: '2026-09-15', dayOfWeek: 'Tue', timeSlot: '12:30–15:45', room: 'C4' },
  { id: 'sch-137', courseId: 'crs-014', semesterId: 'sem-ws2026', date: '2026-09-22', dayOfWeek: 'Tue', timeSlot: '12:30–15:45', room: 'C4' },
  { id: 'sch-168', courseId: 'crs-014', semesterId: 'sem-ws2026', date: '2026-09-29', dayOfWeek: 'Tue', timeSlot: '12:30–15:45', room: 'C4' },
  { id: 'sch-169', courseId: 'crs-014', semesterId: 'sem-ws2026', date: '2026-10-06', dayOfWeek: 'Tue', timeSlot: '12:30–15:45', room: 'C4' },
  { id: 'sch-170', courseId: 'crs-014', semesterId: 'sem-ws2026', date: '2026-10-13', dayOfWeek: 'Tue', timeSlot: '12:30–15:45', room: 'C4' },
  // crs-015: Research Seminar (Wed 08:30)
  { id: 'sch-140', courseId: 'crs-015', semesterId: 'sem-ws2026', date: '2026-09-09', dayOfWeek: 'Wed', timeSlot: '08:30–11:45', room: 'C1' },
  { id: 'sch-141', courseId: 'crs-015', semesterId: 'sem-ws2026', date: '2026-09-16', dayOfWeek: 'Wed', timeSlot: '08:30–11:45', room: 'C1' },
  { id: 'sch-142', courseId: 'crs-015', semesterId: 'sem-ws2026', date: '2026-09-23', dayOfWeek: 'Wed', timeSlot: '08:30–11:45', room: 'C1' },
  { id: 'sch-171', courseId: 'crs-015', semesterId: 'sem-ws2026', date: '2026-09-30', dayOfWeek: 'Wed', timeSlot: '08:30–11:45', room: 'C1' },
  { id: 'sch-172', courseId: 'crs-015', semesterId: 'sem-ws2026', date: '2026-10-07', dayOfWeek: 'Wed', timeSlot: '08:30–11:45', room: 'C1' },
  { id: 'sch-173', courseId: 'crs-015', semesterId: 'sem-ws2026', date: '2026-10-14', dayOfWeek: 'Wed', timeSlot: '08:30–11:45', room: 'C1' },
  // crs-016: Project Seminar (Wed 12:30)
  { id: 'sch-145', courseId: 'crs-016', semesterId: 'sem-ws2026', date: '2026-09-09', dayOfWeek: 'Wed', timeSlot: '12:30–15:45', room: 'Innovation Hub' },
  { id: 'sch-146', courseId: 'crs-016', semesterId: 'sem-ws2026', date: '2026-09-16', dayOfWeek: 'Wed', timeSlot: '12:30–15:45', room: 'Innovation Hub' },
  { id: 'sch-147', courseId: 'crs-016', semesterId: 'sem-ws2026', date: '2026-09-23', dayOfWeek: 'Wed', timeSlot: '12:30–15:45', room: 'Innovation Hub' },
  { id: 'sch-174', courseId: 'crs-016', semesterId: 'sem-ws2026', date: '2026-09-30', dayOfWeek: 'Wed', timeSlot: '12:30–15:45', room: 'Innovation Hub' },
  { id: 'sch-175', courseId: 'crs-016', semesterId: 'sem-ws2026', date: '2026-10-07', dayOfWeek: 'Wed', timeSlot: '12:30–15:45', room: 'Innovation Hub' },
  { id: 'sch-176', courseId: 'crs-016', semesterId: 'sem-ws2026', date: '2026-10-14', dayOfWeek: 'Wed', timeSlot: '12:30–15:45', room: 'Innovation Hub' },
  { id: 'sch-177', courseId: 'crs-016', semesterId: 'sem-ws2026', date: '2026-10-21', dayOfWeek: 'Wed', timeSlot: '12:30–15:45', room: 'Innovation Hub' },
  { id: 'sch-178', courseId: 'crs-016', semesterId: 'sem-ws2026', date: '2026-10-28', dayOfWeek: 'Wed', timeSlot: '12:30–15:45', room: 'Innovation Hub' },
  { id: 'sch-179', courseId: 'crs-016', semesterId: 'sem-ws2026', date: '2026-11-04', dayOfWeek: 'Wed', timeSlot: '12:30–15:45', room: 'Innovation Hub' },
  { id: 'sch-180', courseId: 'crs-016', semesterId: 'sem-ws2026', date: '2026-11-11', dayOfWeek: 'Wed', timeSlot: '12:30–15:45', room: 'Innovation Hub' },
  { id: 'sch-181', courseId: 'crs-016', semesterId: 'sem-ws2026', date: '2026-11-18', dayOfWeek: 'Wed', timeSlot: '12:30–15:45', room: 'Innovation Hub' },
  { id: 'sch-182', courseId: 'crs-016', semesterId: 'sem-ws2026', date: '2026-11-25', dayOfWeek: 'Wed', timeSlot: '12:30–15:45', room: 'Innovation Hub' },
]; // /**
 * Normalized Semester entity data.
 * 
 * Entity: Semester (academic period metadata)
 * ─────────────────────────────────────────────────────────────────────────────
 * id              — unique semester identifier
 * name            — full display name (e.g., 'Summer Semester 2026/27')
 * shortLabel      — abbreviated label (e.g., 'SS 26/27')
 * label           — standard label (e.g., 'SS 2026/27')
 * season          — 'Winter' | 'Summer'
 * calYear         — calendar year semester starts in
 * start           — semester start date (YYYY-MM-DD)
 * end             — semester end date (YYYY-MM-DD)
 * examPeriodStart — exam period start (YYYY-MM-DD)
 * examPeriodEnd   — exam period end (YYYY-MM-DD)
 * status          — 'upcoming' | 'current' | 'completed'
 */

export const SEMESTERS = [
  {
    id: 'sem-ws2025',
    name: 'Winter Semester 2025/26',
    shortLabel: 'WS 25/26',
    label: 'WS 2025/26',
    season: 'Winter',
    calYear: 2025,
    start: '2025-09-01',
    end: '2026-01-23',
    examPeriodStart: '2026-01-12',
    examPeriodEnd: '2026-01-23',
    status: 'completed',
  },
  {
    id: 'sem-ss2026',
    name: 'Summer Semester 2026/27',
    shortLabel: 'SS 26/27',
    label: 'SS 2026/27',
    season: 'Summer',
    calYear: 2026,
    start: '2026-02-23',
    end: '2026-06-26',
    examPeriodStart: '2026-06-08',
    examPeriodEnd: '2026-06-26',
    status: 'current',
  },
  {
    id: 'sem-ws2026',
    name: 'Winter Semester 2026/27',
    shortLabel: 'WS 26/27',
    label: 'WS 2026/27',
    season: 'Winter',
    calYear: 2026,
    start: '2026-09-07',
    end: '2027-01-22',
    examPeriodStart: '2027-01-11',
    examPeriodEnd: '2027-01-22',
    status: 'upcoming',
  },
  {
    id: 'sem-ss2027',
    name: 'Summer Semester 2027/28',
    shortLabel: 'SS 27/28',
    label: 'SS 2027/28',
    season: 'Summer',
    calYear: 2027,
    start: '2027-02-22',
    end: '2027-06-25',
    examPeriodStart: '2027-06-07',
    examPeriodEnd: '2027-06-25',
    status: 'upcoming',
  },
];

export const CURRENT_SEMESTER_ID = 'sem-ss2026';

// Semester slot generator for study planning
export function generateSemesterSlots(startSeason, startYear, maxYears) {
  const slots = [];
  let season = startSeason;
  let calYear = startYear;

  for (let i = 0; i < maxYears * 2; i++) {
    const index = i + 1;
    const label = season === 'Winter'
      ? `WS ${calYear}/${calYear + 1}`
      : `SS ${calYear}/${calYear + 1}`;
    const shortLabel = season === 'Winter'
      ? `WS ${String(calYear).slice(2)}/${String(calYear + 1).slice(2)}`
      : `SS ${String(calYear).slice(2)}/${String(calYear + 1).slice(2)}`;

    slots.push({ index, season, label, shortLabel, calYear });

    if (season === 'Winter') {
      season = 'Summer';
      calYear += 1;
    } else {
      season = 'Winter';
    }
  }
  return slots;
} // /**
 * Student profile & study window configuration.
 *
 * Defines the start of study and generates the full list of semester slots
 * (max 5 years = 10 semesters) that a student can assign courses to.
 */

export const START_SEASON = 'Winter';
export const START_YEAR   = 2025;
export const MAX_YEARS    = 5;
export const MIN_ECTS_PER_YEAR = 20;

/**
 * Generate the complete list of semester slots for the study window.
 * Returns MAX_YEARS * 2 slot objects in chronological order.
 *
 *  { index, season, label, shortLabel, calYear }
 *    index      — 1-based slot number (1 = first semester)
 *    season     — 'Winter' | 'Summer'
 *    label      — full label, e.g. 'WS 2025/26' or 'SS 2026/27'
 *    shortLabel — short label, e.g. 'WS 25/26' or 'SS 26'
 *    calYear    — calendar year the semester starts in
 */
export function generateSemesterSlots(startSeason, startYear, maxYears) {
  const slots = [];
  let season  = startSeason;
  let calYear = startYear;

  for (let i = 0; i < maxYears * 2; i++) {
    const index = i + 1;
    const label = season === 'Winter'
      ? `WS ${calYear}/${calYear + 1}`
      : `SS ${calYear}/${calYear + 1}`;
    const shortLabel = season === 'Winter'
      ? `WS ${String(calYear).slice(2)}/${String(calYear + 1).slice(2)}`
      : `SS ${String(calYear).slice(2)}/${String(calYear + 1).slice(2)}`;

    slots.push({ index, season, label, shortLabel, calYear });

    if (season === 'Winter') { season = 'Summer'; calYear += 1; }
    else                     { season = 'Winter'; }
  }
  return slots;
}

export const SEMESTER_SLOTS = generateSemesterSlots(START_SEASON, START_YEAR, MAX_YEARS);
// index 1  → SS 2026/27
// index 2  → WS 2026/27
// index 3  → SS 2027/28
// index 4  → WS 2027/28
// index 5  → SS 2028/29
// index 6  → WS 2028/29
// index 7  → SS 2029/30
// index 8  → WS 2029/30
// index 9  → SS 2030/31
// index 10 → WS 2030/31

/**
 * Given a year-1 plannedSemester number (1–4) used throughout semesterCourses.js,
 * return the corresponding SEMESTER_SLOTS index.
 * plannedSemester 1 = first semester of study = slot 1 etc.
 */
export function plannedSemToSlotIndex(plannedSem) {
  if (plannedSem == null) return null;
  const n = Number(plannedSem);
  if (n >= 1 && n <= SEMESTER_SLOTS.length) return n;
  return null;
} /**
 * Normalized Student entity data.
 * 
 * Entity: Student
 * ─────────────────────────────────────────────────────────────────────────────
 * id            — unique student identifier
 * userId        — FK → Supabase auth.users.id (links to authenticated user)
 * matricNumber  — official matriculation number
 * firstName     — student's first name
 * lastName      — student's last name
 * email         — university email
 * programmeId   — FK → Programme
 * startSemester — first semester of study (e.g., 'WS 2025/26')
 * startYear     — calendar year of study start
 * startSeason   — 'Winter' | 'Summer'
 * maxYears      — maximum study duration in years
 * minEctsPerYear— minimum ECTS required per year
 * status        — 'active' | 'completed' | 'withdrawn'
 */

export const STUDENTS = [
  {
    id: 'stu-001',
    userId: '5e41c862-eb16-48c8-b70c-a23a5c56c653',
    matricNumber: '2026110001',
    firstName: 'Anzhela',
    lastName: 'Kinash',
    email: 'anzhela.kinash@uni.li',
    programmeId: 'prog-mis',
    startSemester: 'WS 2025/26',
    startYear: 2025,
    startSeason: 'Winter',
    maxYears: 5,
    minEctsPerYear: 20,
    status: 'active',
    role: 'student',
  },
];

// Current logged-in student (mock)
export const CURRENT_STUDENT_ID = 'stu-001'; // /**
 * Normalized ThesisPrerequisite entity data.
 *
 * Entity: ThesisPrerequisite
 * ─────────────────────────────────────────────────────────────────────────────
 * id              — unique identifier
 * programmeId     — FK → Programme
 * moduleId        — FK → Module (must be completed before thesis registration)
 */

export const THESIS_PREREQUISITES = [
  {
    id: 'tp-mis-bs',
    programmeId: 'prog-mis',
    moduleId: 'mod-05',   // Business Statistics
  },
  {
    id: 'tp-mis-rs',
    programmeId: 'prog-mis',
    moduleId: 'mod-rs',   // Research Seminar
  },
];